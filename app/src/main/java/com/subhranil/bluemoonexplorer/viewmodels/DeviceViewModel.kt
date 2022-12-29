package com.subhranil.bluemoonexplorer.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.Device
import com.subhranil.bluemoonexplorer.TestItems.testDevice

class DeviceViewModel: ViewModel() {
    var currentPath by mutableStateOf<String?>(null)
    var device by mutableStateOf(
        testDevice
    )

    fun addPath(newPath: String?){
        currentPath = newPath
    }
    fun addDevice(newDevice: Device){
        device = newDevice
    }
}