package com.base.arch.const

/**
 * @author jacky
 * @date 2021/11/3
 */
class LoadMoreState {

    companion object {
        /**
         * 隐藏
         */
        const val GONE = 0

        /**
         * 正在加载
         */
        const val LOADING = 1

        /**
         * 加载异常
         */
        const val ERROR = 2

        /**
         * 无网络
         */
        const val NO_NETWORK = 3

        /**
         * 没有更多
         */
        const val NO_MORE = 4
    }
}