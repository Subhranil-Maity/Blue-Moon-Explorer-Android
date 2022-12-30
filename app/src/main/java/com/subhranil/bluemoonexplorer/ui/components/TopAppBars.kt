package com.subhranil.bluemoonexplorer.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.viewmodels.DeviceViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlueDeviceTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior
) {
    TopAppBar(
        title = {
            Text(text = "Devices", style = MaterialTheme.typography.titleLarge)
        },
        scrollBehavior = scrollBehavior
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExplorerTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    path: String,
    navController: NavController
) {
    TopAppBar(
        title = {
            Text(
                text = if (path == "null") "Drives" else path,
                style = MaterialTheme.typography.titleLarge
            )
        },
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlueDeviceInfoTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    navController: NavController,
    deviceViewModel: DeviceViewModel
) {
    TopAppBar(
        title = {
            Text(
                text = "Info: ${deviceViewModel.deviceDetails.name}",
                style = MaterialTheme.typography.headlineLarge
            )
        },
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }
    )
}