package com.base.arch.network.interceptor

import com.base.arch.network.base.BaseNetworkApi
import com.base.arch.util.d
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author jacky
 * @date 2021/11/8
 */
class CommonResponseInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val startTime = System.currentTimeMillis()
        val request = chain.request()
        val response = chain.proceed(request)
        d(BaseNetworkApi.TAG, "url=${request.url}, requestTime=${System.currentTimeMillis() - startTime}ms")
        return response
    }
}