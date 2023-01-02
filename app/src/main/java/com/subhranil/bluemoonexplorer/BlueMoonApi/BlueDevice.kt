package com.subhranil.bluemoonexplorer.BlueMoonApi

import com.subhranil.bluemoonexplorer.BlueMoonApi.BlueApiClient.Companion.getClient
import com.subhranil.bluemoonexplorer.models.Device
import com.subhranil.bluemoonexplorer.models.DirItem
import com.subhranil.bluemoonexplorer.models.File
import com.subhranil.bluemoonexplorer.models.Root
import com.subhranil.bluemoonexplorer.utils.Extentions.getFileType
import com.subhranil.bluemoonexplorer.utils.enum.FileType
import com.subhranil.bluemoonexplorer.utils.sortDirItems
import com.subhranil.bluemoonexplorer.viewmodels.GlobalStorageViewModel
import io.ktor.client.*
import io.ktor.client.request.*

//@kotlinx.serialization.Serializable
object BlueDevice {
    private val client: HttpClient = getClient()
    private fun getBaseUrl(device: Device): String {
        return "${device.method.string}${device.host}:${device.port}"
    }

    suspend fun isAlive(device: Device): String {
        return try {
            client.get<Root> {
                url(getBaseUrl(device))
            }.name
        } catch (e: Exception) {
            "Error"
        }
    }

    suspend fun getDir(device: Device, path: String): List<DirItem> {
        return try {
            sortDirItems(
                client.get {
                    url("${getBaseUrl(device)}/dir")
                    parameter("pwd", device.pwd)
                    parameter("path", path)
                }
            ).filter {
                isShowAbleItem(it)
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getRoot(device: Device): Root? {
        return try {
            client.get(getBaseUrl(device))
        } catch (_: Exception) {
            null
        }
    }

    suspend fun getDrives(device: Device): List<DirItem> {
        return try {
            val drives = client.get<Root>(getBaseUrl(device)).drives
            val driveList = drives.map {
                DirItem(
                    name = "Local Disk $it",
                    path = it,
                    size = -1,
                    type = "drive"
                )
            }

            driveList
        } catch (_: Exception) {
            emptyList()
        }
    }

    suspend fun getFile(device: Device, path: String): File? {
        return null
    }
}
fun isShowAbleItem(item: DirItem): Boolean{
    if (item.type == "folder" ){
        if (item.name.startsWith("found.")) return false
        if (item.name.startsWith("$")) return false
    }else{
        if (getFileType(item.name) == FileType.HIDDEN) return false
    }
    return true
}