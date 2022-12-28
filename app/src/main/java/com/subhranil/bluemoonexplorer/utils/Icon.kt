package com.subhranil.bluemoonexplorer.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.DirItem
import com.subhranil.bluemoonexplorer.R
import com.subhranil.bluemoonexplorer.utils.Extentions.getFileType
import com.subhranil.bluemoonexplorer.utils.enum.FileType

object Icon {
    @Composable
    fun determine(item: DirItem): Painter {
        if (item.type == "folder") return painterResource(id = R.drawable.folder)
        if (item.type == "drive") return painterResource(id = R.drawable.drive)
        if (getFileType(item.name) == FileType.PHOTO) return painterResource(id = R.drawable.photo)
        return painterResource(id = R.drawable.file)
    }
}