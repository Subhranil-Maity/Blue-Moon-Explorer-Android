package com.subhranil.bluemoonexplorer.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.BlueMoonApi.BlueDevice
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.DirItem
import com.subhranil.bluemoonexplorer.ui.components.BlueDeviceFloatingActionButton
import com.subhranil.bluemoonexplorer.ui.components.BlueDeviceTopAppBar
import com.subhranil.bluemoonexplorer.ui.components.DirItemCompose
import com.subhranil.bluemoonexplorer.viewmodels.DeviceViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExplorerScreen(
    navController: NavController,
    deviceViewModel: DeviceViewModel,
    path: String?
) {
    val device = deviceViewModel.device
    val dirItems = produceState<List<DirItem>>(
        initialValue = emptyList()
    ) {
        value = if (path == null || path == "null") {
            BlueDevice.getDrives(device)
        } else {
            BlueDevice.getDir(device, path)
        }
    }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { snackbarHostState },
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize(),
        topBar = {
            BlueDeviceTopAppBar(scrollBehavior)
        },
        floatingActionButton = {
            BlueDeviceFloatingActionButton(scope = scope, snackbarHostState = snackbarHostState)
        }
    ) {
        LazyColumn(contentPadding = it){
            items(
                items = dirItems.value
            ){item ->
                DirItemCompose(
                    item,
                    navController
                )
            }
        }
    }
}
