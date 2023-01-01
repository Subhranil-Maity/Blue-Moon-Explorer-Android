package com.subhranil.bluemoonexplorer.utils

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.Settings
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity


fun hasPermission(permission: String, context: Context): Boolean {
    return ContextCompat.checkSelfPermission(
        context,
        permission
    ) == PackageManager.PERMISSION_GRANTED
}

fun getPermissions(permissions: List<String>, activity: Activity): Boolean {
    ActivityCompat.requestPermissions(
        activity,
        permissions.toTypedArray(),
        1
    )
    permissions.forEach { if (!hasPermission(it, context = activity)) return false }
    return true
}

fun getPermission(permission: String, activity: Activity): Boolean {
    return getPermissions(
        listOf(permission),
        activity
    )
}

fun getExternalStoragePermission(activity: Activity): Boolean {
    val permission = listOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    permission.forEach {
        getPermission(
            it,
            activity
        )
    }
    permission.forEach {
        if (!hasPermission(it, activity)) return false
    }
    return true
}

fun hasExternalStoragePermission(activity: Activity): Boolean {
    listOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    ).forEach {
        if (!hasPermission(it, activity)) return false
    }
    return true
}