package com.subhranil.bluemoonexplorer.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.subhranil.bluemoonexplorer.BlueMoonApi.Method
import com.subhranil.bluemoonexplorer.models.Device

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AskForNewDeviceDetailsDialog(
    onDismiss: () -> Unit, onNegativeClick: () -> Unit, onPositiveClick: (Device) -> Unit
) {
    var host by remember { mutableStateOf("") }
    var port by remember { mutableStateOf("") }
    var pwd by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {

        Card(
            elevation = CardDefaults.cardElevation(8.dp), shape = MaterialTheme.shapes.large
        ) {

            Column(modifier = Modifier.padding(8.dp)) {

                Text(
                    text = "Select Color",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {


                    Column {
                        TextField(
                            value = host, onValueChange = { host = it },
                            label = {
                                Text(
                                    text = "Host"
                                )
                            },
                        )
                        TextField(value = port, onValueChange = {
                            if (port.length <= 5) {
                                port = it
                            }
                        }, label = {
                            Text(
                                text = "Port"
                            )
                        },
                        maxLines = 1)
                        TextField(value = pwd, onValueChange = { pwd = it }, label = {
                            Text(
                                text = "Password"
                            )
                        })
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()
                ) {

                    TextButton(onClick = onNegativeClick) {
                        Text(text = "CANCEL")
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    TextButton(onClick = {
                        onPositiveClick(
                            Device(
                                host = host, port = port.toInt(), pwd = pwd, method = Method.http
                            )
                        )
                    }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}
