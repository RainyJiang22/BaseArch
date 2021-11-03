package com.base.arch.base.list

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.base.arch.base.list.base.BaseViewData
import com.base.arch.databinding.BaseRecyclerviewBinding

/**
 * @author jacky
 * @date 2021/11/3
 * 自定义recyclerview
 */
class CustomRecyclerView constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val viewBinding =
        BaseRecyclerviewBinding.inflate(LayoutInflater.from(context), this, true)

    fun performItemClick(view: View, viewData: BaseViewData<*>, position: Int, id: Long) {
        // 点击监听(含加载更多item点击监听)
    }

    fun performItemLongClick(
        view: View,
        viewData: BaseViewData<*>,
        position: Int,
        id: Long
    ): Boolean {
        // 长按监听
        var consumed = false

        return consumed
    }

    fun performItemChildViewClick(
        view: View,
        viewData: BaseViewData<*>,
        position: Int,
        id: Long,
        extra: Any?
    ) {
    }

    interface OnItemClickListener {
        fun onItemClick(parent: RecyclerView, view: View, viewData: BaseViewData<*>, position: Int, id: Long)
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(
            parent: RecyclerView,
            view: View,
            viewData: BaseViewData<*>,
            position: Int,
            id: Long
        ): Boolean
    }

    interface OnItemChildViewClickListener {
        fun onItemChildViewClick(
            parent: RecyclerView,
            view: View,
            viewData: BaseViewData<*>,
            position: Int,
            id: Long,
            extra: Any?
        )
    }
}