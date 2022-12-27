package com.subhranil.bluemoonexplorer.BlueMoonApi.models

@kotlinx.serialization.Serializable
data class File(
    val name: String,
    val size: Long,
    val content: String,
    val type: String
)
