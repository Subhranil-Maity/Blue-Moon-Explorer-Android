package com.subhranil.bluemoonexplorer.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.ui.components.BlueDeviceInfoEditFloatingActionButton
import com.subhranil.bluemoonexplorer.ui.components.BlueDeviceInfoTopAppBar
import com.subhranil.bluemoonexplorer.viewmodels.DeviceViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceInfoScreen(
    navController: NavController,
    deviceViewModel: DeviceViewModel
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize(),
        topBar = {
            BlueDeviceInfoTopAppBar(
                scrollBehavior,
                navController = navController,
                deviceViewModel = deviceViewModel
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
            Text(text = "IP: ${deviceViewModel.device.host}", style = MaterialTheme.typography.titleLarge)
            Text(text = "PORT: ${deviceViewModel.device.port}", style = MaterialTheme.typography.titleLarge)
            Text(text = "METHOD: ${deviceViewModel.device.method.string}", style = MaterialTheme.typography.titleLarge)
            Text(text = "PWD: ${deviceViewModel.device.pwd}", style = MaterialTheme.typography.titleLarge)
            Text(text = "PLATFORM: ${deviceViewModel.deviceDetails.platform}", style = MaterialTheme.typography.titleLarge)
        }
    }
}