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
import com.subhranil.bluemoonexplorer.models.Device
import com.subhranil.bluemoonexplorer.R
import com.subhranil.bluemoonexplorer.Screens.Screen
import com.subhranil.bluemoonexplorer.viewmodels.DeviceViewModel


