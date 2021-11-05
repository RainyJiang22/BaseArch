package com.base.arch.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.base.arch.R
import com.base.arch.databinding.ViewLoadingBinding

/**
 * @author jacky
 * @date 2021/11/5
 */
class LoadingView constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    val viewBinding = ViewLoadingBinding.inflate(LayoutInflater.from(context), this, true).apply {
        viewLoading.setViewColor(ContextCompat.getColor(context, R.color.theme_color))
    }

    override fun setVisibility(visibility: Int) {
        super.setVisibility(visibility)
        if (visibility == View.VISIBLE) {
            viewBinding.viewLoading.startAnim()
        } else {
            viewBinding.viewLoading.stopAnim()
        }
    }

    override fun onDetachedFromWindow() {
        viewBinding.viewLoading.stopAnim()
        super.onDetachedFromWindow()
    }

}