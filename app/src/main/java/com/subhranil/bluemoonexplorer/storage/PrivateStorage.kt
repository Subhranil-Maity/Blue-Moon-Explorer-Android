package com.subhranil.bluemoonexplorer.storage

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

class PrivateStorage(
    activity: Activity
) {
    private val sharedPref: SharedPreferences = activity.getPreferences(Context.MODE_PRIVATE)

    fun setString(key: String, value: String) {
        with(sharedPref.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getString(key: String): String? {
        return sharedPref.getString(key, null)
    }
    fun delete(key: String){
        with(sharedPref.edit()){
            remove(key)
            apply()
        }
    }
}