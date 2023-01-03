package com.subhranil.bluemoonexplorer.utils

import com.subhranil.bluemoonexplorer.utils.enum.FileType

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
    private val audio = listOf(
        "mp3",
        "pcm",
        "wav",
        "aiff",
        "aac",
        "ogg",
        "wma",
        "flac"
    )
    private val video = listOf(
        "mp4",
        "mov",
        "wmv",
        "avi",
        "avchd",
        "flv",
        "f4v",
        "swf",
        "mkv",
        "webm",
        "html5",
        "mpeg-2"
    )
    fun getFileType(name: String): FileType {
        val extension: String = name.substringAfterLast(".").lowercase()
        if (extension in photos) return FileType.PHOTO
        if (extension in hiddenFileType) return FileType.HIDDEN
        if (extension in audio) return FileType.AUDIO
        if (extension in video) return FileType.VIDEO
        return FileType.UNKNOWN
    }
}