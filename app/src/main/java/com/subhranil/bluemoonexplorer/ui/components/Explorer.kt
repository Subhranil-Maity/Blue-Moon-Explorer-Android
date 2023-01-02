package com.subhranil.bluemoonexplorer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.subhranil.bluemoonexplorer.models.DirItem
import com.subhranil.bluemoonexplorer.Screens.Screen
import com.subhranil.bluemoonexplorer.utils.ItemIcon
import com.subhranil.bluemoonexplorer.utils.ItemIcon.GetIcon
import com.subhranil.bluemoonexplorer.viewmodels.GlobalStorageViewModel


@Composable
fun Explorer(
    navController: NavController,
    globalStorageViewModel: GlobalStorageViewModel,
    path: String?
) {

}
@Composable
fun DirItemCompose(
    item: DirItem,
    navController: NavController
){
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
            GetIcon(item)
            Text(item.name, style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.onBackground)
            Column(modifier = Modifier) {

            }
        }
    }
}