package com.base.arch.eventbus

import androidx.lifecycle.Observer
import com.base.arch.util.reflect.ReflectHelper

/**
 * @author jacky
 * @date 2021/11/2
 */
class EventObserverWrapper<T>(
    liveData: EventLiveData<T>,
    sticky: Boolean,
    private val observerDelegate: Observer<in T>
) : Observer<T> {

    private var preventNextEvent = false

    companion object {
        private const val START_VERSION = -1
    }

    init {
        if (!sticky) {
            val version = ReflectHelper.of(liveData).getField("mVersion") as? Int ?: START_VERSION
            preventNextEvent = version > START_VERSION
        }
    }

    override fun onChanged(t: T) {
        if (preventNextEvent) {
            preventNextEvent = false
            return
        }
        observerDelegate.onChanged(t)
    }
}