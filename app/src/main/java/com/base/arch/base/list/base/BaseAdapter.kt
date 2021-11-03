package com.base.arch.base.list.base

import com.base.arch.base.list.multitype.MultiTypeAdapter

/**
 * @author jacky
 * @date 2021/11/3
 */
open class BaseAdapter : MultiTypeAdapter() {

    init {

    }


    open fun setViewData(viewData: List<BaseViewData<*>>) {
       items.clear()
       items.addAll(viewData)
       notifyDataSetChanged()
    }

    open fun replaceViewData(viewData: BaseViewData<*>, position: Int) {
        if (position in 0 until itemCount) {
            items[position] = viewData
            notifyItemChanged(position)
        }
    }

    open fun addViewData(viewData: BaseViewData<*>) {
        val oldSize = itemCount
        items.add(viewData)
        notifyItemInserted(oldSize)
    }

    open fun addViewData(viewData: List<BaseViewData<*>>) {
        val oldSize = itemCount
        items.addAll(viewData)
        notifyItemRangeInserted(oldSize, itemCount)
    }

    open fun removeViewData(position: Int): BaseViewData<*>? {
        var removedViewData: BaseViewData<*>? = null
        if (position in 0 until itemCount) {
            removedViewData = items.removeAt(position)
            notifyItemRemoved(position)
        }
        return removedViewData
    }

    open fun removeViewData(viewData: BaseViewData<*>): BaseViewData<*>? {
        val position = items.indexOf(viewData)
        return removeViewData(position)
    }

    open fun clearViewData() {
        val oldSize = itemCount
        items.clear()
        notifyItemRangeRemoved(0, oldSize)
    }

    open fun getViewData(position: Int): BaseViewData<*>? {
        return if (position in 0 until itemCount) {
            items[position]
        } else {
            null
        }
    }


}