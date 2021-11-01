package com.base.arch

import android.app.ActivityManager
import android.app.Application
import android.os.Process


/**
 * @author jacky
 * @date 2021/11/1
 */
class BaseArchApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initMainProcess {
            instance = this
        }
    }


    /**
     * 主进程初始化
     */
    private fun initMainProcess(block: () -> Unit) {
        val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val myPId = Process.myPid()
        val mainProcessName = packageName
        activityManager.runningAppProcesses.forEach {
            if (it.pid == myPId && it.processName == mainProcessName) {
                block()
            }
        }
    }

    companion object {
        lateinit var instance: Application
    }
}