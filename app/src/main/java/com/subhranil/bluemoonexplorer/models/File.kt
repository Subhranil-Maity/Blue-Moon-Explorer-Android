package com.subhranil.bluemoonexplorer.models

@kotlinx.serialization.Serializable
data class File(
    val name: String,
    val size: Long,
    val content: String,
    val type: String
)
