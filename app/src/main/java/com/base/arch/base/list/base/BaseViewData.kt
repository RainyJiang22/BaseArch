package com.base.arch.base.list.base

/**
 * @author jacky
 * @date 2021/11/3
 * 将具体数据类型再套一层BaseViewData以实现更多item布局类型
 * 重写equals和hashCode是为后面的DiffUtil
 */
open class BaseViewData<T>(var value: T) {

    override fun equals(other: Any?): Boolean {
        if (other is BaseViewData<*>) {
            return value?.equals(other.value) ?: false
        }
        return false
    }

    override fun hashCode(): Int {
        return value?.hashCode() ?: 0
    }
}
