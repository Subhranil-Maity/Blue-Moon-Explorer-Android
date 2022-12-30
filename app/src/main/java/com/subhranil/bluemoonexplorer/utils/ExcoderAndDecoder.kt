package com.subhranil.bluemoonexplorer.utils

import com.subhranil.bluemoonexplorer.models.Device

const val separator = "@@@###"
fun encodeDevice(
    device: Device
): String{
    return device.host + separator + device.port + separator + device.method.string + separator + device.pwd
}