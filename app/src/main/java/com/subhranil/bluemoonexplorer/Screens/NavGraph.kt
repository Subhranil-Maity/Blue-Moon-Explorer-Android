package com.subhranil.bluemoonexplorer.Screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.subhranil.bluemoonexplorer.viewmodels.GlobalStorageViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    scope: LifecycleCoroutineScope
) {
    val globalStorageViewModel: GlobalStorageViewModel = viewModel()
//    loadStorage(globalStorageViewModel)
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