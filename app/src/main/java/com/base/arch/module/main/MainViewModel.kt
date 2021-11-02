package com.base.arch.module.main

import com.base.arch.base.BaseViewModel
import com.base.arch.const.PageName

/**
 * @author jacky
 * @date 2021/11/1
 */
class MainViewModel : BaseViewModel() {
    override fun getPageName(): String = PageName.MAIN
}