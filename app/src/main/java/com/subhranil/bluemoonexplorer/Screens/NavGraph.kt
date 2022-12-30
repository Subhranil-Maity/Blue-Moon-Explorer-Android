package com.subhranil.bluemoonexplorer.Screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.subhranil.bluemoonexplorer.viewmodels.DeviceViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    val deviceViewModel: DeviceViewModel = viewModel()
    val scope = rememberCoroutineScope()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route,

            ) {
            HomeScreen(
                navController
            )
        }
        composable(
            route = Screen.SelectBlueDevice.route,

            ) {
            SelectBlueDeviceScreen(
                deviceViewModel, navController,
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
                deviceViewModel = deviceViewModel,
                path = it.arguments?.getString(PATH_ARGS_KEY),
                scope = scope
            )

        }
        composable(
            route = Screen.DeviceInfoScreen.route
        ) {
            DeviceInfoScreen(
                navController = navController,
                deviceViewModel = deviceViewModel
            )
        }
    }
}