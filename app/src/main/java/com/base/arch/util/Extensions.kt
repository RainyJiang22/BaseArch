package com.base.arch.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View

/**
 * @author jacky
 * @date 2021/11/1
 */
/**
 * Boolean转Visibility
 */
fun Boolean.toVisibility() = if (this) View.VISIBLE else View.GONE

/**
 * Context转Activity
 */
fun Context.getActivity(): Activity? {
    return when (this) {
        is Activity -> {
            this
        }
        is ContextWrapper -> {
            this.baseContext.getActivity()
        }
        else -> null
    }
}
