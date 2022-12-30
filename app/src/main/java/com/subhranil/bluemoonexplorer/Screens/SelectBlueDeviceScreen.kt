package com.subhranil.bluemoonexplorer.Screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.TestItems.testDevice
import com.subhranil.bluemoonexplorer.ui.components.BlueDeviceCard
import com.subhranil.bluemoonexplorer.ui.components.BlueDeviceFloatingActionButton
import com.subhranil.bluemoonexplorer.ui.components.BlueDeviceTopAppBar
import com.subhranil.bluemoonexplorer.viewmodels.DeviceViewModel
import kotlinx.coroutines.CoroutineScope


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectBlueDeviceScreen(
    deviceViewModel: DeviceViewModel,
    navController: NavController,
    scope: CoroutineScope
){


    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
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
        LazyColumn(
            contentPadding = it
        ) {
            item {

                BlueDeviceCard(
                    navController,
                    deviceViewModel = deviceViewModel,
                    device = testDevice
                )
            }
        }
    }
}