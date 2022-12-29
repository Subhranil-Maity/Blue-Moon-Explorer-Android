package com.subhranil.bluemoonexplorer.utils

//import androidx.compose.material3.Ca
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.subhranil.bluemoonexplorer.BlueMoonApi.BlueDevice.getRoot
import com.subhranil.bluemoonexplorer.BlueMoonApi.models.Root
import com.subhranil.bluemoonexplorer.R
import com.subhranil.bluemoonexplorer.Screens.Screen
import com.subhranil.bluemoonexplorer.viewmodels.DeviceViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DevicePlaceholder(
    navController: NavController,
    deviceViewModel: DeviceViewModel,
    modifier: Modifier = Modifier
) {
    val device = deviceViewModel.device
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
    ) {
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
                        if (details.value.drives != emptyList<String>()) {
                            deviceViewModel.addDevice(device)
                            deviceViewModel.addPath(null)
                            navController.navigate(
                                Screen.ExplorerScreen.setPath(null)
                            )
                        }
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
}