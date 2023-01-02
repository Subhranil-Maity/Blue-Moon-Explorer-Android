package com.subhranil.bluemoonexplorer.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun CustomDialogWithResultExample(
    onDismiss: () -> Unit, onNegativeClick: () -> Unit, onPositiveClick: (Color) -> Unit
) {
    var host by remember { mutableStateOf("") }
    var port by remember { mutableStateOf("") }
    var pwd by remember { mutableStateOf("") }
    var red by remember { mutableStateOf(0f) }
    var green by remember { mutableStateOf(0f) }
    var blue by remember { mutableStateOf(0f) }

    val color = Color(
        red = red.toInt(), green = green.toInt(), blue = blue.toInt(), alpha = 255
    )

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

                        Text(text = "Red ${red.toInt()}")
                        Slider(value = red,
                            onValueChange = { red = it },
                            valueRange = 0f..255f,
                            onValueChangeFinished = {})
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = "Green ${green.toInt()}")
                        Slider(value = green,
                            onValueChange = { green = it },
                            valueRange = 0f..255f,
                            onValueChangeFinished = {})
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = "Blue ${blue.toInt()}")
                        Slider(value = blue,
                            onValueChange = { blue = it },
                            valueRange = 0f..255f,
                            onValueChangeFinished = {})

                        Spacer(modifier = Modifier.height(8.dp))
                        Surface(
                            border = BorderStroke(1.dp, Color.DarkGray),
                            color = color,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                        ) {}
                    }
                }

                // Buttons
                Row(
                    horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()
                ) {

                    TextButton(onClick = onNegativeClick) {
                        Text(text = "CANCEL")
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    TextButton(onClick = {
                        onPositiveClick(color)
                    }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}
