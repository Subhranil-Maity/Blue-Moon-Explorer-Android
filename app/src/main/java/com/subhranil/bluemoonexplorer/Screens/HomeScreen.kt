package com.subhranil.bluemoonexplorer.Screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.ui.components.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    scope: CoroutineScope
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize(),
        topBar = {
            HomeTopAppBar(scrollBehavior = scrollBehavior, navController = navController)
        },
        floatingActionButton = {
            HomeFloatingActionButton(scope = scope, navController = navController)
        }
    ) {
        
    }

}