package com.subhranil.bluemoonexplorer.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle

enum class DialogResponse {
    CONFIRM,
    DISMISS
}

@Composable
fun ShowDialog(
    title: String,
    description: String,
    titleStyle: TextStyle = MaterialTheme.typography.headlineLarge,
    descriptionStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    action: (DialogResponse, MutableState<Boolean>) -> Unit = { _, state -> state.value = false},
) {
    val alertState = remember { mutableStateOf(true) }
    AlertDialog(
        onDismissRequest = { alertState.value = false },
        title = { Text(text = title, style = titleStyle) },
        text = {
            Text(text = description, style = descriptionStyle)
        },
        confirmButton = {
            Button(onClick = {
                action(DialogResponse.CONFIRM, alertState)
            }) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            Button(onClick = {
                action(DialogResponse.DISMISS, alertState)
            }) {
                Text(text = "Dismiss")
            }
        }
    )
}