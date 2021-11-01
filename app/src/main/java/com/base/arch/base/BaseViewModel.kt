package com.base.arch.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * @author jacky
 * @date 2021/11/1
 * ViewModel基类
 */
class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


    /**
     * 添加Disposable
     */
    protected fun addDisposable(disposable: CompositeDisposable) {
        compositeDisposable.add(disposable)
    }

}