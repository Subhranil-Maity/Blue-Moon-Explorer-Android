package com.subhranil.bluemoonexplorer.BlueMoonApi

import android.util.Log
import com.subhranil.bluemoonexplorer.BlueMoonApi.BlueApiClient.Companion.getClient
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.Device
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.DirItems
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
    suspend fun getDir(device: Device, path: String): List<DirItems>{
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
    suspend fun getFile(device: Device, path: String): File?{
        return null
    }
}