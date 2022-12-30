package com.subhranil.bluemoonexplorer.utils

import com.subhranil.bluemoonexplorer.models.DirItem

fun sortDirItems(items: List<DirItem>): List<DirItem>{
    return items.sortedByDescending {
        it.type
    }
}