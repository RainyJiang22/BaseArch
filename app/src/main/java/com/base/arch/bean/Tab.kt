package com.base.arch.bean

import com.base.arch.base.BaseFragment
import com.base.arch.const.TabId
import kotlin.reflect.KClass

/**
 * @author jacky
 * @date 2021/11/1
 */
data class Tab(
   @TabId
   val id: String,
   val title: String,
   val icon: Int,
   val fragmentClz: KClass<out BaseFragment<*>>
)