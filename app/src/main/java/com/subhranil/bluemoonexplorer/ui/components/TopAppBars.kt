package com.subhranil.bluemoonexplorer.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.R
import com.subhranil.bluemoonexplorer.viewmodels.GlobalStorageViewModel

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
    globalStorageViewModel: GlobalStorageViewModel
) {
    TopAppBar(
        title = {
            Text(
                text = "Info: ${globalStorageViewModel.deviceDetails.name}",
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    navController: NavController
) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier.height(50.dp).width(50.dp)
                )
                Text(
                    text = "BlueMoon Explorer",
                    style = MaterialTheme.typography.headlineLarge
                )
            }

        },
        scrollBehavior = scrollBehavior
    )
}