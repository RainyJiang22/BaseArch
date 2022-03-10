package com.base.arch.module.radio

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.base.arch.base.BaseFragment
import com.base.arch.const.PageName
import com.base.arch.databinding.FragmentRadioBinding

/**
 * @author jacky
 * @date 2021/11/1
 */
class RadioFragment : BaseFragment<FragmentRadioBinding>(FragmentRadioBinding::inflate) {

    private val viewModel: RadioViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun getPageName(): String = PageName.RADIO

    private fun initView() {
        viewBinding.rvFragmentOutter.showShimmerAdapter()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        //添加页面打点
    }
}