package com.base.arch.module.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.base.arch.R
import com.base.arch.base.BaseFragment
import com.base.arch.const.EventName
import com.base.arch.const.PageName
import com.base.arch.databinding.FragmentHomeBinding
import com.base.arch.eventbus.BaseEventBus
import com.base.arch.module.main.MainViewModel

/**
 * @author jacky
 * @date 2021/11/1
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    private fun initData() {

        viewModel.sectionListData.observe(viewLifecycleOwner) {
            val video = it.getOrNull()
            if (null != video) {
                viewBinding.tvHome.text = video.data.toString()
            } else {
                viewBinding.tvHome.text = resources.getString(R.string.page_state_network_error)
            }
        }

        viewModel.requestSectionList()
    }

    override fun getPageName(): String {
        return PageName.HOME
    }

    private fun initView() {
        BaseEventBus.observe(viewLifecycleOwner, EventName.TEST) { message: String ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}