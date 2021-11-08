package com.base.arch.module.home

import androidx.lifecycle.viewModelScope
import com.base.arch.base.BaseViewModel
import com.base.arch.bean.SectionListBean
import com.base.arch.const.PageName
import com.base.arch.eventbus.MutableLiveData
import com.base.arch.network.ZhiHuApi
import kotlinx.coroutines.launch

/**
 * @author jacky
 * @date 2021/11/1
 */
class HomeViewModel : BaseViewModel() {

    val sectionListData = MutableLiveData<Result<SectionListBean>>()

    fun requestSectionList() {
        viewModelScope.launch {
            val result = ZhiHuApi.requestSectionList()
            sectionListData.value = result
        }
    }

    override fun getPageName(): String = PageName.HOME
}