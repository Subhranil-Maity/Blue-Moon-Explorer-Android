package com.subhranil.bluemoonexplorer.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.Screens.Screen
import com.subhranil.bluemoonexplorer.models.Device
import com.subhranil.bluemoonexplorer.models.Root
import com.subhranil.bluemoonexplorer.viewmodels.DeviceViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreDeviceAssistChip(
    details: State<Root>,
    navController: NavController,
    deviceViewModel: DeviceViewModel,
    device: Device
) {
    AssistChip(
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoOfDeviceAssistChip(navController: NavController) {
    AssistChip(
        onClick = {
            navController.navigate(
                Screen.DeviceInfoScreen.route
            )
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
}