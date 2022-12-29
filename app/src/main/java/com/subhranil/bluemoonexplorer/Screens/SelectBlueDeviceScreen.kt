package com.subhranil.bluemoonexplorer.Screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.TestItems
import com.subhranil.bluemoonexplorer.ui.components.BlueDeviceTopAppBar
import com.subhranil.bluemoonexplorer.utils.DevicePlaceholder
import com.subhranil.bluemoonexplorer.viewmodels.DeviceViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectBlueDeviceScreen(
    deviceViewModel: DeviceViewModel,
    navController: NavController
){


    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize(),
        topBar = {
            BlueDeviceTopAppBar(scrollBehavior)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            "Not Yet Implemented"
                        )
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    ) {
        LazyColumn(
            contentPadding = it
        ) {
            item {

                DevicePlaceholder(
                    navController,
                    deviceViewModel = deviceViewModel
                )
            }
        }
    }
}