package com.subhranil.bluemoonexplorer.Screens

import com.subhranil.bluemoonexplorer.models.Device
import com.subhranil.bluemoonexplorer.utils.encodeDevice

const val PATH_ARGS_KEY = "path"
const val DEVICE_ARGS_KEY = "device"

sealed class Screen(val route: String){
    object Home: Screen("home_screen")
    object SelectBlueDevice: Screen("select_blue_device_screen")
    object DeviceInfoScreen: Screen("device_info_screen")
    object ExplorerScreen: Screen("explorer_screen/{$PATH_ARGS_KEY}"){
        fun setPath(path: String?): String{
            return "explorer_screen/$path"
        }
    }
}
