package com.subhranil.bluemoonexplorer.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlueDeviceTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior
){
    TopAppBar(
        title = {
            Text(text = "Devices", style = MaterialTheme.typography.titleLarge)
        },
        scrollBehavior = scrollBehavior
    )
}