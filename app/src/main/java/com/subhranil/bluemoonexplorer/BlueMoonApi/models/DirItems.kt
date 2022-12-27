package com.subhranil.bluemoonexplorer.BlueMoonApi.models

@kotlinx.serialization.Serializable
data class DirItems(
    val name: String,
    val path: String,
    val size: Long,
    val type: String
)
