package com.subhranil.bluemoonexplorer.models

import com.subhranil.bluemoonexplorer.BlueMoonApi.Method

@kotlinx.serialization.Serializable
data class Device(
    val host: String,
    val port: Int,
    val method: Method,
    var pwd: String?,
    var details: Root? = null
)
