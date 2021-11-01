package com.base.arch.module.main


import android.os.Bundle
import com.base.arch.base.BaseActivity
import com.base.arch.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSystemBar()
    }


    //禁止左滑返回
    override fun swipeBackEnable(): Boolean {
        return false
    }


    /**
     * 状态栏导航栏初始化
     */
    private fun initSystemBar() {
    }
}