package com.subhranil.bluemoonexplorer.models

@kotlinx.serialization.Serializable
data class Root(
    val name: String,
    val default_location: String,
    val drives: List<String>,
    val platform: String,
    val version: String
)
