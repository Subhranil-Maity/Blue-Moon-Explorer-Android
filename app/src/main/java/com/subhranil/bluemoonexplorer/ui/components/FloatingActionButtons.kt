package com.subhranil.bluemoonexplorer.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.Screens.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDeviceFloatingActionButton(
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState
){



    var showCustomDialogWithResult by remember { mutableStateOf(false) }


    if (showCustomDialogWithResult) {
        CustomDialogWithResultExample(
            onDismiss = {
                showCustomDialogWithResult = !showCustomDialogWithResult

            },
            onNegativeClick = {
                showCustomDialogWithResult = !showCustomDialogWithResult

            },
            onPositiveClick = { color ->
                showCustomDialogWithResult = !showCustomDialogWithResult

            }
        )
    }
    FloatingActionButton(
        onClick = {
            showCustomDialogWithResult = true
        }
    ) {
        Icon(
            imageVector = Icons.Outlined.Edit,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}
@Composable
fun BlueDeviceInfoEditFloatingActionButton(
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState
){

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
@Composable
fun HomeFloatingActionButton(
    scope: CoroutineScope,
    navController: NavController
){
    FloatingActionButton(
        onClick = {
            scope.launch {
                navController.navigate(Screen.SelectBlueDevice.route)
            }
        }
    ) {
        Icon(
            imageVector = Icons.Outlined.Edit,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}