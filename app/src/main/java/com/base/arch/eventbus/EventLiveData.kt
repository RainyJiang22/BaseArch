package com.base.arch.eventbus

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

/**
 * @author jacky
 * @date 2021/11/2
 */
class EventLiveData<T> : MutableLiveData<T>() {

    fun observe(owner: LifecycleOwner, sticky: Boolean, observer: Observer<in T>) {
        observe(owner, wrapObserver(sticky, observer))
    }

    private fun wrapObserver(sticky: Boolean, observer: Observer<in T>): Observer<T> {
        return EventObserverWrapper(this, sticky, observer)
    }
}