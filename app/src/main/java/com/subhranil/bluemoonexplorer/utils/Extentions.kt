package com.subhranil.bluemoonexplorer.utils

import com.subhranil.bluemoonexplorer.utils.enum.FileType
import java.util.*

object Extentions {
    private val photos = listOf<String>(
        "jpeg",
        "png",
        "jpg",
        "raw"
    )
    fun getFileType(name: String): FileType {
        val extention: String = name.substringAfterLast(".").lowercase()
        if (extention in photos) return FileType.PHOTO
        return FileType.UNKNOWN
    }
}