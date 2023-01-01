package com.subhranil.bluemoonexplorer.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.coroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.subhranil.bluemoonexplorer.Screens.SetupNavGraph
import com.subhranil.bluemoonexplorer.ui.components.DialogResponse
import com.subhranil.bluemoonexplorer.ui.components.ShowDialog
import com.subhranil.bluemoonexplorer.ui.theme.BlueMoonExplorerTheme
import com.subhranil.bluemoonexplorer.utils.getExternalStoragePermission
import com.subhranil.bluemoonexplorer.utils.hasExternalStoragePermission

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BlueMoonExplorerTheme {
                if (!hasExternalStoragePermission(this)) {
                    if(getExternalStoragePermission(this))
                        showExitMsg(this, "Permissions Not Granted which are very necessary")
                }
                navController = rememberNavController()
                SetupNavGraph(
                    navController = navController,
                    lifecycle.coroutineScope
                )
            }
        }
    }

}




