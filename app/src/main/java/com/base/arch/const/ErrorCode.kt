package com.base.arch.const

/**
 * @author jacky
 * @date 2021/11/8
 */
class ErrorCode {
    companion object {
        const val OK = 200
        const val UNAUTHORIZED = 401
        const val CUSTOM_FIRST = 600
        const val VALUE_IS_NULL = CUSTOM_FIRST + 1
    }
}