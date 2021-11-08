package com.base.arch.module.about

import android.os.Bundle
import com.base.arch.base.BaseActivity
import com.base.arch.const.EventName
import com.base.arch.const.PageName
import com.base.arch.databinding.ActivityAboutBinding
import com.base.arch.eventbus.BaseEventBus

/**
 * @author jacky
 * @date 2021/11/8
 */
class AboutActivity : BaseActivity<ActivityAboutBinding>(ActivityAboutBinding::inflate) {
    override fun getPageName(): String = PageName.ABOUT


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        viewBinding.tvAbout.setOnClickListener {
            BaseEventBus.post(EventName.TEST,"来自关于页面的消息")
        }
    }
}