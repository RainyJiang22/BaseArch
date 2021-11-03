package com.base.arch.util

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.provider.Settings
import com.base.arch.BaseArchApplication

/**
 * @author jacky
 * @date 2021/11/3
 */
fun isNetworkConnect(): Boolean {
    val cm = BaseArchApplication.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return cm.activeNetworkInfo?.isAvailable ?: false
}

fun toNetworkSetting(context: Context) {
    val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
    context.startActivity(intent)
}