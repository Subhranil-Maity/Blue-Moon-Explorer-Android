package com.subhranil.bluemoonexplorer.Screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun HomeScreen(
    navController: NavController
) {
    navController.navigate(
        route = Screen.SelectBlueDevice.route
    )
}