package com.subhranil.bluemoonexplorer.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.subhranil.bluemoonexplorer.models.Device
import com.subhranil.bluemoonexplorer.models.Root
import com.subhranil.bluemoonexplorer.TestItems.testDevice

class DeviceViewModel : ViewModel() {
    var currentPath by mutableStateOf<String?>(null)
    var device by mutableStateOf(
        testDevice
    )
    var deviceDetails by mutableStateOf(
        Root(
            name = device.host,
            default_location = "",
            drives = emptyList(),
            platform = "",
            version = ""
        )
    )

    fun addPath(newPath: String?) {
        currentPath = newPath
    }

    fun addDevice(newDevice: Device) {
        device = newDevice
    }
    fun addDetails(newDetails: Root){
        deviceDetails = newDetails
    }
}