package com.subhranil.bluemoonexplorer.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.Screens.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun BlueDeviceFloatingActionButton(
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
            imageVector = Icons.Outlined.Edit,
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