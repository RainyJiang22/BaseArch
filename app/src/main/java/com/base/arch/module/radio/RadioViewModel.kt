package com.base.arch.module.radio

import com.base.arch.base.BaseViewModel
import com.base.arch.base.list.base.BaseRecyclerViewModel
import com.base.arch.bean.RadioBean
import com.base.arch.const.PageName
import com.base.arch.item.RadioViewData

/**
 * @author jacky
 * @date 2021/11/1
 */
class RadioViewModel : BaseRecyclerViewModel() {

    override fun needNetwork(): Boolean {
        return false
    }

    override fun loadData(isLoadMore: Boolean, isReLoad: Boolean, page: Int) {

        //模拟加载数据
        val insertData = listOf(
            RadioBean(1, "交通电台", null),
            RadioBean(2, "音乐电台", null),
            RadioBean(3, "戏剧电台", null)
        )

        val viewData = mutableListOf<RadioViewData>()

        insertData.forEach { bean ->
            viewData.add(RadioViewData(bean))
        }

        postData(isLoadMore, viewData)
    }


    override fun getPageName(): String = PageName.MINE
}