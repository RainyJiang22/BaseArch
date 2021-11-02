package com.base.arch.module.mine

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.base.arch.base.BaseFragment
import com.base.arch.const.EventName
import com.base.arch.const.PageName
import com.base.arch.databinding.FragmentMineBinding
import com.base.arch.eventbus.BaseEventBus

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

        BaseEventBus.observe(viewLifecycleOwner, EventName.TEST) { message: String ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}