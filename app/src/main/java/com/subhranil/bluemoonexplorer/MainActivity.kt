package com.subhranil.bluemoonexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.subhranil.bluemoonexplorer.BlueMoonApi.BlueDevice.getDir
import com.subhranil.bluemoonexplorer.BlueMoonApi.Method
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.Device
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.DirItems
import com.subhranil.bluemoonexplorer.destinations.ExplorerScreenDestination
import com.subhranil.bluemoonexplorer.ui.theme.BlueMoonExplorerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlueMoonExplorerTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
                ){
                    DestinationsNavHost(navGraph = NavGraphs.root)
                }

            }
        }
    }



}

@RootNavGraph(start = true)
@Destination()
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {
                navigator.navigate(
                    ExplorerScreenDestination(
                        device = Device(
                            host = "192.168.225.50",
                            port = 65432,
                            method = Method.http,
                            pwd = "admin"
                        ),
                        null
                    )
                )
            }
        ) {
            Text(text = "Go")
        }
    }

}

@Destination
@Composable
fun ExplorerScreen(
    navigator: DestinationsNavigator,
    device: Device,
    path: String?
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Explorer(navigator = navigator, device = device, path = path?:"c:/")
    }
}

@Composable
fun Explorer(navigator: DestinationsNavigator, device: Device, path: String) {
    val items = produceState<List<DirItems>>(
        initialValue = emptyList(),
        producer = {
            value = getDir(device, path)
        })
    Column(
        modifier = Modifier
            .verticalScroll(
                rememberScrollState()
            )
            .fillMaxSize()
    ) {
        items.value.forEach { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable(onClick = {
                        navigator.navigate(
                            ExplorerScreenDestination(
                                device = device,
                                path = item.path
                            )
                        )
                    })
            ) {
                Row(modifier = Modifier) {
                    Image(
                        if (item.type == "file")
                            painterResource(id = R.drawable.file)
                        else painterResource(id = R.drawable.folder),
                        contentDescription = "Icon"
                    )
                    Text(item.name)
                    Column(modifier = Modifier) {

                    }
                }
            }
        }
    }
}
@Composable
private fun FilesOrFolder(navigator: DestinationsNavigator, item: DirItems) {

}


