package com.subhranil.bluemoonexplorer.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.Screens.Screen
import com.subhranil.bluemoonexplorer.viewmodels.GlobalStorageViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDeviceFloatingActionButton(
    globalStorageViewModel: GlobalStorageViewModel
) {


    var showCustomDialogWithResult by remember { mutableStateOf(false) }


    if (showCustomDialogWithResult) {
        AskForNewDeviceDetailsDialog(onDismiss = {
            showCustomDialogWithResult = !showCustomDialogWithResult

        }, onNegativeClick = {
            showCustomDialogWithResult = !showCustomDialogWithResult

        }, onPositiveClick = { device ->
            globalStorageViewModel.addToDeviceList(device)
            globalStorageViewModel.saveDeviceList()
            showCustomDialogWithResult = !showCustomDialogWithResult

        })
    }
    FloatingActionButton(onClick = {
        showCustomDialogWithResult = true
    }) {
        Icon(
            imageVector = Icons.Outlined.Edit,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
fun BlueDeviceInfoEditFloatingActionButton(
    scope: CoroutineScope, snackbarHostState: SnackbarHostState
) {

    FloatingActionButton(onClick = {
        scope.launch {
            snackbarHostState.showSnackbar(
                "Not Yet Implemented"
            )
        }
    }) {
        Icon(
            imageVector = Icons.Outlined.Add,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }

}

@Composable
fun HomeFloatingActionButton(
    scope: CoroutineScope, navController: NavController
) {
    FloatingActionButton(onClick = {
        scope.launch {
            navController.navigate(Screen.SelectBlueDevice.route)
        }
    }) {
        Icon(
            imageVector = Icons.Outlined.Edit,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}