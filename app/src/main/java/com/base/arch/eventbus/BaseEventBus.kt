package com.base.arch.eventbus

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

/**
 * @author jacky
 * @date 2021/11/2
 */
object BaseEventBus {

    private val channels = HashMap<String, EventLiveData<*>>()

    private fun <T> with(eventName: String): EventLiveData<T> {
        synchronized(channels) {
            if (!channels.containsKey(eventName)) {
                channels[eventName] = EventLiveData<T>()
            }
            return (channels[eventName] as EventLiveData<T>)
        }
    }

    fun <T> post(eventName: String, message: T) {
        val eventLiveData = with<T>(eventName)
        eventLiveData.postValue(message)
    }

    fun <T> observe(owner: LifecycleOwner, eventName: String, sticky: Boolean = false, observer: Observer<T>) {
        with<T>(eventName).observe(owner, sticky, observer)
    }

    fun post(eventName: String) {
        val eventLiveData = with<EmptyMessage>(eventName)
        eventLiveData.postValue(EmptyMessage)
    }

    fun observe(owner: LifecycleOwner, eventName: String, sticky: Boolean = false, observer: () -> Unit) {
        with<EmptyMessage>(eventName).observe(owner, sticky) {
            observer()
        }
    }
}