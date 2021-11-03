package com.base.arch.base.list.base

import com.base.arch.base.BaseViewModel
import com.base.arch.bean.LoadError
import com.base.arch.eventbus.MutableLiveData
import com.base.arch.util.isNetworkConnect
import java.util.concurrent.atomic.AtomicInteger

/**
 * @author jacky
 * @date 2021/11/3
 */
abstract class BaseRecyclerViewModel : BaseViewModel() {

    /**
     * 首页/下拉刷新的数据
     */
    val firstViewDataLiveData = MutableLiveData<List<BaseViewData<*>>>()


    /**
     * 更多的数据
     */
    val moreViewDataLiveData = MutableLiveData<List<BaseViewData<*>>>()


    /**
     * 页码
     */
    private var currentPage = AtomicInteger(0)


    /**
     * 子类重写这个函数加载数据
     */
    abstract fun loadData(isLoadMore: Boolean, isReLoad: Boolean, page: Int)


    fun loadDataInternal(isLoadMore: Boolean, isReLoad: Boolean) {
        if (needNetwork() && !isNetworkConnect()) {
            postError(isLoadMore)
            return
        }

        if (!isLoadMore) {
            currentPage.set(0)
        } else if (!isReLoad) {
            currentPage.incrementAndGet()
        }
        loadData(isLoadMore, isReLoad, currentPage.get())
    }


    /**
     * 获取当前页码
     */
    fun getCurrentPage(): Int {
        return currentPage.get()
    }


    /**
     * 子类可以实现这个方法,返回加载数据是否需要网络
     */
    open fun needNetwork(): Boolean {
        return true
    }


    /**
     * 提交数据
     */
    protected fun postData(isLoadMore: Boolean, viewData: List<BaseViewData<*>>) {
        if (isLoadMore) {
            moreViewDataLiveData.postValue(viewData)
        } else {
            firstViewDataLiveData.postValue(viewData)
        }
    }


    /**
     * 提交加载数据
     */
    protected fun postError(isLoadMore: Boolean) {
        if (isLoadMore) {
            moreViewDataLiveData.postValue(LoadError)
        } else {
            firstViewDataLiveData.postValue(LoadError)
        }
    }


}