package com.subhranil.bluemoonexplorer

import com.subhranil.bluemoonexplorer.BlueMoonApi.Method
import com.subhranil.bluemoonexplorer.models.Device

object TestItems {
    val testDevice = Device(
        host = "192.168.225.50",
        port = 65432,
        method = Method.http,
        pwd = "admin",
        details = null
    )
}