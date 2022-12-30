package com.subhranil.bluemoonexplorer.BlueMoonApi

import com.subhranil.bluemoonexplorer.BlueMoonApi.BlueApiClient.Companion.getClient
import com.subhranil.bluemoonexplorer.models.Device
import com.subhranil.bluemoonexplorer.models.DirItem
import com.subhranil.bluemoonexplorer.models.File
import com.subhranil.bluemoonexplorer.models.Root
import com.subhranil.bluemoonexplorer.utils.sortDirItems
import com.subhranil.bluemoonexplorer.viewmodels.DeviceViewModel
import io.ktor.client.*
import io.ktor.client.request.*
//@kotlinx.serialization.Serializable
object BlueDevice{
    private val client: HttpClient = getClient()
    private fun getBaseUrl(device: Device): String{
        return "${device.method.string}${device.host}:${device.port}"
    }
    suspend fun isAlive(device: Device): String{
        return try {
            client.get<Root> {
                url(getBaseUrl(device))
            }.name
        } catch(e: Exception){
            "Error"
        }
    }
    suspend fun getDir(device: Device, path: String): List<DirItem>{
        return try {
            sortDirItems(
                client.get {
                    url("${getBaseUrl(device)}/dir")
                    parameter("pwd", device.pwd)
                    parameter("path", path)
                }
            )
        }catch (e: Exception){
            emptyList()
        }
    }
    suspend fun getRoot(device: Device): Root?{
        return try {
            client.get(getBaseUrl(device))
        }catch (_: Exception){
            null
        }
    }
    suspend fun getDrives(device: Device): List<DirItem>{
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
        }catch (_: Exception){
            emptyList()
        }
    }
    suspend fun loadDetails(deviceViewModel: DeviceViewModel){
        if (deviceViewModel.device.details != null) return
        val device = deviceViewModel.device
        val details = client.get<Root>(getBaseUrl(device))
        device.details = details
        deviceViewModel.addDevice(device)
    }
    suspend fun getFile(device: Device, path: String): File?{
        return null
    }
}