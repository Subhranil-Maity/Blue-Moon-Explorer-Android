package com.subhranil.bluemoonexplorer.Screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.ui.components.AddDeviceFloatingActionButton
import com.subhranil.bluemoonexplorer.ui.components.BlueDeviceCard
import com.subhranil.bluemoonexplorer.ui.components.BlueDeviceTopAppBar
import com.subhranil.bluemoonexplorer.viewmodels.GlobalStorageViewModel
import kotlinx.coroutines.CoroutineScope


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectBlueDeviceScreen(
    globalStorageViewModel: GlobalStorageViewModel,
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
            AddDeviceFloatingActionButton(globalStorageViewModel)
        }
    ) {
        LazyColumn(
            contentPadding = it,
            modifier = Modifier.padding(5.dp)
        ) {
            items(globalStorageViewModel.deviceList.size){ item ->
                BlueDeviceCard(
                    navController,
                    globalStorageViewModel = globalStorageViewModel,
                    device = globalStorageViewModel.deviceList[item]
                )
            }

        }
    }
}