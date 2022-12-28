package com.subhranil.bluemoonexplorer.BlueMoonApi

import android.util.Log
import com.subhranil.bluemoonexplorer.BlueMoonApi.BlueApiClient.Companion.getClient
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.Device
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.DirItem
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.File
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.Root
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
                url("" + getBaseUrl(device))
            }.name
        } catch(e: Exception){
            Log.d("HELLO", "\n\n\n$e\n\n\n")
            "Error"
        }
    }
    suspend fun getDir(device: Device, path: String): List<DirItem>{
        return try {
            client.get {
                url("${getBaseUrl(device)}/dir")
                parameter("pwd", device.pwd)
                parameter("path", path)
            }
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
            val driveList = mutableListOf<DirItem>()
            for (drive in drives){
                driveList += DirItem(
                    name = "Local Disk $drive",
                    path = drive,
                    size = -1,
                    type = "drive"
                )
            }

            driveList
        }catch (_: Exception){
            emptyList()
        }
    }
    suspend fun getFile(device: Device, path: String): File?{
        return null
    }
}