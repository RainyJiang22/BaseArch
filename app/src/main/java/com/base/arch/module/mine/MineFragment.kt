package com.base.arch.module.mine

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.base.arch.base.BaseFragment
import com.base.arch.const.EventName
import com.base.arch.const.PageName
import com.base.arch.databinding.FragmentMineBinding
import com.base.arch.eventbus.BaseEventBus
import com.base.arch.module.about.AboutActivity

/**
 * @author jacky
 * @date 2021/11/1
 */
class MineFragment : BaseFragment<FragmentMineBinding>(FragmentMineBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun getPageName(): String = PageName.MINE


    private fun initView() {
        viewBinding.eventTest.setOnClickListener {
            startActivity(Intent(activity, AboutActivity::class.java))
        }
    }
}