package com.base.arch.const

import androidx.annotation.StringDef

/**
 * @author jacky
 * @date 2021/11/1
 */
@StringDef(TabId.HOME, TabId.RADIO, TabId.MINE)
@Retention(AnnotationRetention.SOURCE)
annotation class TabId {
    companion object {
        const val HOME = "home"
        const val RADIO = "radio"
        const val MINE = "mine"
    }
}