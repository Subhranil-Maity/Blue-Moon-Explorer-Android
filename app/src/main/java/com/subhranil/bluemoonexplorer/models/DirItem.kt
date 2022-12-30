package com.subhranil.bluemoonexplorer.models

@kotlinx.serialization.Serializable
data class DirItem(
    val name: String,
    val path: String,
    val size: Long,
    val type: String
)
