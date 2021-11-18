package com.base.arch.module.radio

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.base.arch.R
import com.base.arch.base.BaseFragment
import com.base.arch.base.list.CustomRecyclerView
import com.base.arch.base.list.base.BaseViewData
import com.base.arch.const.PageName
import com.base.arch.databinding.FragmentRadioBinding
import com.base.arch.util.BlurUtil

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
        viewBinding.rvList.init(
            CustomRecyclerView.Config()
                .setViewModel(viewModel)
                .setPullRefreshEnable(false)
                .setPullUploadMoreEnable(false)
                .setOnItemClickListener(object : CustomRecyclerView.OnItemClickListener {
                    override fun onItemClick(
                        parent: RecyclerView,
                        view: View,
                        viewData: BaseViewData<*>,
                        position: Int,
                        id: Long
                    ) {
                        Toast.makeText(context, "条目点击: ${viewData.value}", Toast.LENGTH_SHORT)
                            .show()
                    }

                })
        )
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        //添加页面打点
    }
}