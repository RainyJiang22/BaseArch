package com.base.arch.base.list.multitype

import androidx.recyclerview.widget.RecyclerView
import com.nan.xarch.base.list.multitype.ItemViewBinder

/**
 * @author Drakeet Xu
 */
abstract class ViewHolderInflater<T, VH : RecyclerView.ViewHolder> : ItemViewBinder<T, VH>()
