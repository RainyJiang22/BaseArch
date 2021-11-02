package com.base.arch.util

import android.util.Log
import com.base.arch.BuildConfig
import java.util.*

/**
 * @author jacky
 * @date 2021/11/2
 */
private fun isLoggable(): Boolean {
    return BuildConfig.DEBUG
}

fun i(tag: String, fmt: String, vararg args: Any) {
    if (isLoggable()) {
        Log.i(tag, format(fmt, *args))
    }
}

fun d(tag: String, fmt: String, vararg args: Any) {
    if (isLoggable()) {
        Log.d(tag, format(fmt, *args))
    }
}

fun w(tag: String, fmt: String, vararg args: Any) {
    if (isLoggable()) {
        Log.w(tag, format(fmt, *args))
    }
}

fun e(tag: String, fmt: String, vararg args: Any) {
    if (isLoggable()) {
        Log.e(tag, format(fmt, *args))
    }
}

fun e(tag: String, t: Throwable, fmt: String, vararg args: Any) {
    if (isLoggable()) {
        Log.e(tag, format(fmt, *args), t)
    }
}

private fun format(fmt: String, vararg args: Any): String {
    return if (args.isEmpty()) {
        fmt
    } else {
        String.format(Locale.getDefault(), fmt, *args)
    }
}