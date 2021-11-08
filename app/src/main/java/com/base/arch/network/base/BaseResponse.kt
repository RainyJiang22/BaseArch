package com.base.arch.network.base

/**
 * @author jacky
 * @date 2021/11/8
 */
data class BaseResponse<T>(
    var code: Int = 0,
    val msg: String? = null,
    val redirect: String? = null,
    val value: T? = null
)