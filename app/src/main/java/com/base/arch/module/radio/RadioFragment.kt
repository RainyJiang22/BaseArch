package com.base.arch.module.radio

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.base.arch.R
import com.base.arch.base.BaseFragment
import com.base.arch.const.PageName
import com.base.arch.databinding.FragmentRadioBinding
import com.base.arch.util.BlurUtil

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

        val bitmap = BlurUtil.blur(
            requireContext(),
            ContextCompat.getDrawable(requireContext(), R.drawable.test),
            0.4f,
            8f
        )
        viewBinding.radioBg.setImageBitmap(bitmap)
    }
}