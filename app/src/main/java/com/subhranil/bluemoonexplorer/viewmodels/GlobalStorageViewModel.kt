package com.subhranil.bluemoonexplorer.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.subhranil.bluemoonexplorer.models.Device
import com.subhranil.bluemoonexplorer.models.Root
import com.subhranil.bluemoonexplorer.TestItems.testDevice

class GlobalStorageViewModel : ViewModel() {
    var currentPath by mutableStateOf<String?>(null)
    var currentDevice by mutableStateOf(
        testDevice
    )
    private var deviceList = mutableStateListOf<Device>()
    var deviceDetails by mutableStateOf(
        Root(
            name = currentDevice.host,
            default_location = "",
            drives = emptyList(),
            platform = "",
            version = ""
        )
    )

    fun addPath(newPath: String?) {
        currentPath = newPath
    }
    fun addToDeviceList(newDevice: Device){
        deviceList.add(newDevice)
    }
    fun selectDevice(newDevice: Device) {
        currentDevice = newDevice
    }
    fun addDetails(newDetails: Root){
        deviceDetails = newDetails
    }
}