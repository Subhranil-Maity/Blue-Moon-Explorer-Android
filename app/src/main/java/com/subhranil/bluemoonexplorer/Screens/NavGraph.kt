package com.subhranil.bluemoonexplorer.Screens

import android.app.Activity
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.subhranil.bluemoonexplorer.models.Device
import com.subhranil.bluemoonexplorer.models.Root
import com.subhranil.bluemoonexplorer.storage.PrivateStorage
import com.subhranil.bluemoonexplorer.viewmodels.GlobalStorageViewModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    scope: LifecycleCoroutineScope
) {
    val storage: PrivateStorage = PrivateStorage(LocalContext.current as Activity)
    val globalStorageViewModel: GlobalStorageViewModel = viewModel()
    globalStorageViewModel.setPrivateStorage(storage)

    if (storage.getString("devices") != null){
        Json.decodeFromString<List<Device>>(storage.getString("devices")!!).forEach {
            globalStorageViewModel.addToDeviceList(it)
        }
    }

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route,

            ) {
            HomeScreen(
                navController,
                scope
            )
        }
        composable(
            route = Screen.SelectBlueDevice.route,

            ) {
            SelectBlueDeviceScreen(
                globalStorageViewModel, navController,
                scope = scope
            )
        }
        composable(
            route = Screen.ExplorerScreen.route,
            arguments = listOf(
                navArgument(PATH_ARGS_KEY){
                    type = NavType.StringType
                }
            )
        ) {

            ExplorerScreen(
                navController = navController,
                globalStorageViewModel = globalStorageViewModel,
                path = it.arguments?.getString(PATH_ARGS_KEY),
                scope = scope
            )

        }
        composable(
            route = Screen.DeviceInfoScreen.route
        ) {
            DeviceInfoScreen(
                navController = navController,
                globalStorageViewModel = globalStorageViewModel,
                scope = scope
            )
        }
    }
}