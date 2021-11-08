package com.base.arch.network

import com.base.arch.network.base.BaseNetworkApi
import com.base.arch.network.service.ZhiHuService

/**
 * @author jacky
 * @date 2021/11/8
 */
object ZhiHuApi : BaseNetworkApi<ZhiHuService>("http://news-at.zhihu.com/api/4/") {


    /**
     * 获取专题日报
     */
    suspend fun requestSectionList()  = getResult {
        service.requestSectionList()
    }




}