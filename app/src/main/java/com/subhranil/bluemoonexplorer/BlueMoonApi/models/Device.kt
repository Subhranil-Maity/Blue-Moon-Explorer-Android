package com.subhranil.bluemoonexplorer.BlueMoonApi.models

import com.subhranil.bluemoonexplorer.BlueMoonApi.Method

@kotlinx.serialization.Serializable
data class Device(
    val host: String,
    val port: Int,
    val method: Method,
    var pwd: String?
)
