package com.subhranil.bluemoonexplorer

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.subhranil.bluemoonexplorer.Screens.SetupNavGraph
import com.subhranil.bluemoonexplorer.ui.theme.BlueMoonExplorerTheme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlueMoonExplorerTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                }
            }
        }
    }

    fun getContext(): Context {
        return this
    }

}




