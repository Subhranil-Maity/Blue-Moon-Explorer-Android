package com.subhranil.bluemoonexplorer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.subhranil.bluemoonexplorer.BlueMoonApi.BlueDevice
import com.subhranil.bluemoonexplorer.R
import com.subhranil.bluemoonexplorer.models.Device
import com.subhranil.bluemoonexplorer.viewmodels.GlobalStorageViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlueDeviceCard(
    navController: NavController,
    globalStorageViewModel: GlobalStorageViewModel,
    modifier: Modifier = Modifier,
    device: Device
) {
//    val device = deviceViewModel.device
    val details = produceState(
        initialValue = globalStorageViewModel.deviceDetails,
        producer = {
            value = BlueDevice.getRoot(device) ?: value
            globalStorageViewModel.addDetails(value)
        }
    )
    ElevatedCard(
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
                InfoOfDeviceAssistChip(
                    navController = navController
                )
                ExploreDeviceAssistChip(
                    details = details,
                    navController = navController,
                    globalStorageViewModel = globalStorageViewModel,
                    device = device
                )

            }
        }
    }
}