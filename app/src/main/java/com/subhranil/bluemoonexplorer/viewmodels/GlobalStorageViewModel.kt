package com.subhranil.bluemoonexplorer.viewmodels

import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.subhranil.bluemoonexplorer.models.Device
import com.subhranil.bluemoonexplorer.models.Root
import com.subhranil.bluemoonexplorer.TestItems.testDevice
import com.subhranil.bluemoonexplorer.storage.PrivateStorage
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class GlobalStorageViewModel: ViewModel() {
    var currentPath by mutableStateOf<String?>(null)
    private var storage: PrivateStorage? = null
    var currentDevice by mutableStateOf<Device?>(
        testDevice
    )
    var deviceList = mutableListOf<Device>()

    fun addPath(newPath: String?) {
        currentPath = newPath
    }
    fun addToDeviceList(newDevice: Device){
        deviceList.add(newDevice)
    }
    fun selectDevice(newDevice: Device) {
        currentDevice = newDevice
    }
    fun setPrivateStorage(newStorage: PrivateStorage){
        storage = newStorage
    }
    fun saveDeviceList() {
        storage!!.setString("devices", Json.encodeToString(deviceList))
    }
}