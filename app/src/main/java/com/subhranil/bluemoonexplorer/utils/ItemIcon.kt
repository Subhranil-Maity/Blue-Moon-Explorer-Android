package com.subhranil.bluemoonexplorer.utils

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.subhranil.bluemoonexplorer.R
import com.subhranil.bluemoonexplorer.models.DirItem
import com.subhranil.bluemoonexplorer.utils.Extentions.getFileType
import com.subhranil.bluemoonexplorer.utils.enum.FileType

object ItemIcon {
    @Composable
    fun determine(item: DirItem): Painter {
        if (item.type == "folder") return painterResource(id = R.drawable.folder)
        if (item.type == "drive") return painterResource(id = R.drawable.storage)
        if (getFileType(item.name) == FileType.PHOTO) return painterResource(id = R.drawable.image)
        return painterResource(id = R.drawable.file)
    }

    @Composable
    fun GetIcon(item: DirItem) {
        Icon(
            painter = determine(item = item),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
        )

    }
}