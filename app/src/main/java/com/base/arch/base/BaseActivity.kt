package com.base.arch.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import me.imid.swipebacklayout.lib.app.SwipeBackActivity

/**
 * @author jacky
 * @date 2021/11/1
 * Activity基类
 */
abstract class BaseActivity<T : ViewBinding>(val inflater: (inflater: LayoutInflater) -> T) : SwipeBackActivity() {

    protected lateinit var viewBinding: T
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = inflater(layoutInflater)
        setContentView(viewBinding.root)
        setSwipeBackEnable(swipeBackEnable())
    }


    override fun onStart() {
        super.onStart()
        //这里进行打点
    }


    override fun onStop() {
        super.onStop()
        //这里进行打点
    }


    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    //默认开启左滑返回
    protected open fun swipeBackEnable() = true


    /**
     * 添加Disposable
     */
    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}