package com.base.arch.module.home

import android.os.Bundle
import android.view.View
import com.base.arch.base.BaseFragment
import com.base.arch.databinding.FragmentHomeBinding

/**
 * @author jacky
 * @date 2021/11/1
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

    }
}