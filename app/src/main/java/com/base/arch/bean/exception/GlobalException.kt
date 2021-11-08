package com.base.arch.bean.exception

/**
 * @author jacky
 * @date 2021/11/5
 * Global全局异常
 */
class GlobalException private constructor(message: String) : RuntimeException(message) {
    companion object {
        fun of(message: String) = GlobalException(message)
    }
}