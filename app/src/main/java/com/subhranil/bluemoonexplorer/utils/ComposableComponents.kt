package com.subhranil.bluemoonexplorer.utils

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.*
//import androidx.compose.material3.Ca
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.subhranil.bluemoonexplorer.BlueMoonApi.BlueDevice
import com.subhranil.bluemoonexplorer.BlueMoonApi.BlueDevice.getRoot
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.Device
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.DirItem
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.Root
import com.subhranil.bluemoonexplorer.R
import com.subhranil.bluemoonexplorer.destinations.ExplorerScreenDestination


@Composable
fun Explorer(navigator: DestinationsNavigator, device: Device, path: String?) {
    val items = produceState<List<DirItem>>(
        initialValue = emptyList(),
        producer = {
            value = if (path == null){
                BlueDevice.getDrives(device)
            }else{
                BlueDevice.getDir(device, path)
            }
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
                    .height(52.dp)
                    .clickable(onClick = {
                        if (item.type != "file") {
                            navigator.navigate(
                                ExplorerScreenDestination(
                                    device = device,
                                    path = item.path
                                )
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
                    Text(item.name)
                    Column(modifier = Modifier) {

                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DevicePlaceholder(
    device: Device,
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier
) {
        val details = produceState(
            initialValue = Root(
                name = device.host,
                default_location = "",
                drives = emptyList(),
                platform = "",
                version = ""
            ),
            producer = {
                value = getRoot(device) ?: value
            }
        )
        Card(
            modifier = modifier,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            shape = MaterialTheme.shapes.large
        ){
            Image(
                painter = painterResource(id = R.drawable.win11),
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = details.value.name, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(10.dp))
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    mainAxisSpacing = 8.dp,
                    mainAxisSize = SizeMode.Wrap
                ) {
                    ElevatedAssistChip(
                        onClick = {
                        /*TODO*/
                        },
                        colors = AssistChipDefaults.assistChipColors(
                            leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        leadingIcon = {
                            Icon(imageVector = Icons.Outlined.Info, contentDescription = null)
                        },
                        label = {
                            Text(text = "Information")
                        }
                    )
                    ElevatedAssistChip(
                        onClick = {
                         navigator.navigate(ExplorerScreenDestination(device = device, null))
                        },
                        colors = AssistChipDefaults.assistChipColors(
                            leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        leadingIcon = {
                            Icon(imageVector = Icons.Outlined.ThumbUp, contentDescription = null)
                        },
                        label = {
                            Text(text = "Explore")
                        }
                    )
                }
            }
        }
//        Row(
//            modifier = Modifier
//                .padding(4.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(text = details.value.name, color = MaterialTheme.colorScheme.inverseSurface)
//            Spacer(Modifier.weight(0.5f))
//            Text(text = if (details.value.drives == emptyList<String>()) "Checking..." else "Online", color = MaterialTheme.colorScheme.inverseSurface)
//            Button(
//                onClick = {
//                    TODO("")
//                }
//            ) {
//                Text(text = "Explore")
//            }
//        }
//
//    }
}