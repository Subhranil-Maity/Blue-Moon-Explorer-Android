package com.subhranil.bluemoonexplorer.utils

import com.subhranil.bluemoonexplorer.models.DirItem
import com.subhranil.bluemoonexplorer.utils.enum.FileType

fun sortDirItems(items: List<DirItem>): List<DirItem>{
    return items.sortedByDescending {
        it.type
    }
}