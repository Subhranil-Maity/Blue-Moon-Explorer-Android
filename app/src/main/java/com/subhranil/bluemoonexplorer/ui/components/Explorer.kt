package com.subhranil.bluemoonexplorer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.BlueMoonApi.BlueDevice
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.Device
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.DirItem
import com.subhranil.bluemoonexplorer.Screens.Screen
import com.subhranil.bluemoonexplorer.utils.Icon
import com.subhranil.bluemoonexplorer.viewmodels.DeviceViewModel


@Composable
fun Explorer(
    navController: NavController,
    deviceViewModel: DeviceViewModel,
    path: String?
) {
    val device = deviceViewModel.device
    val items = produceState<List<DirItem>>(
        initialValue = emptyList()
    ) {
        value = if (path == null || path == "null") {
            BlueDevice.getDrives(device)
        } else {
            BlueDevice.getDir(device, path)
        }
    }
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
                    .height(52.dp)
                    .clickable(onClick = {
                        if (item.type != "file") {
                            navController.navigate(
                                route = Screen.ExplorerScreen.setPath(item.path)
                            )
                        } else {
                            // TODO
                        }
                    })
            ) {
                Row(modifier = Modifier) {
                    Image(
                        painter = Icon.determine(item),
                        contentDescription = "Icon"
                    )
                    Text(item.name, style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.onBackground)
                    Column(modifier = Modifier) {

                    }
                }
            }
        }
    }
}