package com.base.arch.network.service

import com.base.arch.bean.SectionListBean
import com.base.arch.network.base.BaseResponse
import retrofit2.http.GET

/**
 * @author jacky
 * @date 2021/11/8
 */
interface ZhiHuService {

    @GET("sections")
    suspend fun requestSectionList() : BaseResponse<SectionListBean>
}