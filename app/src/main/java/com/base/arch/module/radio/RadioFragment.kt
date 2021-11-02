package com.base.arch.module.radio

import android.os.Bundle
import android.view.View
import com.base.arch.base.BaseFragment
import com.base.arch.const.PageName
import com.base.arch.databinding.FragmentRadioBinding

/**
 * @author jacky
 * @date 2021/11/1
 */
class RadioFragment : BaseFragment<FragmentRadioBinding>(FragmentRadioBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun getPageName(): String = PageName.RADIO

    private fun initView() {

    }
}