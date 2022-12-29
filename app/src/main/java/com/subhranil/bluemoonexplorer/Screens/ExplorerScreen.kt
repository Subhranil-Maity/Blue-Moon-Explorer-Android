package com.subhranil.bluemoonexplorer.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.ui.components.Explorer
import com.subhranil.bluemoonexplorer.viewmodels.DeviceViewModel

@Composable
fun ExplorerScreen(
    navController: NavController,
    deviceViewModel: DeviceViewModel,
    path: String?
) {
    val device = deviceViewModel.device
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Explorer(
            navController = navController,
            deviceViewModel = deviceViewModel,
            path = path
        )
    }
}
