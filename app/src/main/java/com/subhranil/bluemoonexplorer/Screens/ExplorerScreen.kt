package com.subhranil.bluemoonexplorer.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.BlueMoonApi.BlueDevice
import com.subhranil.bluemoonexplorer.models.DirItem
import com.subhranil.bluemoonexplorer.ui.components.*
import com.subhranil.bluemoonexplorer.viewmodels.GlobalStorageViewModel
import kotlinx.coroutines.CoroutineScope

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExplorerScreen(
    navController: NavController,
    globalStorageViewModel: GlobalStorageViewModel,
    path: String?,
    scope: CoroutineScope
) {
    val device = globalStorageViewModel.currentDevice!!
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
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize(),
        topBar = {
            ExplorerTopAppBar(
                scrollBehavior = scrollBehavior,
                path = path ?: "null",
                navController = navController
            )
        },
        floatingActionButton = {
//            HomeFloatingActionButton(scope = scope, snackbarHostState = snackbarHostState)
        },

        ) {
        LazyColumn(contentPadding = it) {
            items(
                items = dirItems.value
            ) { item ->
                DirItemCompose(
                    item,
                    navController
                )
            }
        }
    }
}
