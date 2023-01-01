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
    private val hiddenFileType = listOf(
        "temp",
        "tmp",
        "dat",
        "sys",
        "ini"
    )
    fun getFileType(name: String): FileType {
        val extention: String = name.substringAfterLast(".").lowercase()
        if (extention in photos) return FileType.PHOTO
        if (extention in hiddenFileType) return FileType.HIDDEN
        return FileType.UNKNOWN
    }
}