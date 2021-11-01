package com.base.arch.module.mine

import android.os.Bundle
import android.view.View
import com.base.arch.base.BaseFragment
import com.base.arch.databinding.FragmentMineBinding

/**
 * @author jacky
 * @date 2021/11/1
 */
class MineFragment : BaseFragment<FragmentMineBinding>(FragmentMineBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

    }
}