package com.subhranil.bluemoonexplorer.Screens

import androidx.compose.runtime.Composable
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
                deviceViewModel, navController
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
                path = it.arguments?.getString(PATH_ARGS_KEY)
            )

        }
    }
}