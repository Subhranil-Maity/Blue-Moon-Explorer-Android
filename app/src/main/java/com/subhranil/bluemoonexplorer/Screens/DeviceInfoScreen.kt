package com.subhranil.bluemoonexplorer.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.ui.components.BlueDeviceInfoEditFloatingActionButton
import com.subhranil.bluemoonexplorer.ui.components.BlueDeviceInfoTopAppBar
import com.subhranil.bluemoonexplorer.viewmodels.GlobalStorageViewModel
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceInfoScreen(
    navController: NavController,
    globalStorageViewModel: GlobalStorageViewModel,
    scope: CoroutineScope
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize(),
        topBar = {
            BlueDeviceInfoTopAppBar(
                scrollBehavior,
                navController = navController,
                globalStorageViewModel = globalStorageViewModel
            )
        },
        floatingActionButton = {
            BlueDeviceInfoEditFloatingActionButton(
                scope = scope,
                snackbarHostState = snackbarHostState
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Text(text = "IP: ${globalStorageViewModel.currentDevice.host}", style = MaterialTheme.typography.titleLarge)
            Text(text = "PORT: ${globalStorageViewModel.currentDevice.port}", style = MaterialTheme.typography.titleLarge)
            Text(text = "METHOD: ${globalStorageViewModel.currentDevice.method.string}", style = MaterialTheme.typography.titleLarge)
            Text(text = "PWD: ${globalStorageViewModel.currentDevice.pwd}", style = MaterialTheme.typography.titleLarge)
            Text(text = "PLATFORM: ${globalStorageViewModel.deviceDetails.platform}", style = MaterialTheme.typography.titleLarge)
        }
    }
}