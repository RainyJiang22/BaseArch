package com.base.arch.item

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.base.arch.base.list.base.BaseItemViewDelegate
import com.base.arch.databinding.ItemRadioBinding

/**
 * @author jacky
 * @date 2021/11/18
 */
class RadioViewDelegate : BaseItemViewDelegate<RadioViewData,RadioViewDelegate.ViewHolder>() {
    override fun onCreateViewHolder(
        inflater: LayoutInflater,
        context: Context,
        parent: ViewGroup
    ): ViewHolder {
        return ViewHolder(ItemRadioBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: RadioViewData) {
        super.onBindViewHolder(holder, item)
        holder.viewBinding.rName.text = item.value.name
        //TODO 可使用网络地址
    }

    class ViewHolder(val viewBinding: ItemRadioBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    }
}