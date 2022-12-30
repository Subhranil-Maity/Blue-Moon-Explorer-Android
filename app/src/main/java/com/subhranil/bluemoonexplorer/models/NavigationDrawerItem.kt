package com.subhranil.bluemoonexplorer.models

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationDrawerItem(
    val id: String,
    val title: String,
    val contentDescription: String?,
    val Icon: ImageVector
)
