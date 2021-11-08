package com.base.arch.network.interceptor

import android.os.Build
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author jacky
 * @date 2021/11/8
 */
class CommonRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        // 这里添加公共请求头
        builder.addHeader("brand", Build.BRAND)
        builder.addHeader("model", Build.MODEL)
        return chain.proceed(builder.build())
    }


}