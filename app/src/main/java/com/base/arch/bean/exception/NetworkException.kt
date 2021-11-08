package com.base.arch.bean.exception

/**
 * @author jacky
 * @date 2021/11/5
 * Network异常
 */
class NetworkException private constructor(val code: Int, message: String) : RuntimeException(message) {

    override fun toString(): String {
        return "exception code is $code msg is $message"
    }

    companion object {
        fun of(code: Int, message: String) = NetworkException(code, message)
    }

}