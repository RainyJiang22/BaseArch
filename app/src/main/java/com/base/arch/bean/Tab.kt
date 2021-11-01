package com.base.arch.bean

import com.base.arch.base.BaseFragment
import kotlin.reflect.KClass

/**
 * @author jacky
 * @date 2021/11/1
 */
data class Tab(
   val id: String,
   val title: String,
   val icon: Int,
   val fragmentClz: KClass<out BaseFragment<*>>
)