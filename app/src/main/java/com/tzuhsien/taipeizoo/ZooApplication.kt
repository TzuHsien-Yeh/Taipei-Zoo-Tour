package com.tzuhsien.taipeizoo

import android.app.Application
import android.content.Context
import com.tzuhsien.taipeizoo.BuildConfig
import com.tzuhsien.taipeizoo.data.AppContainer
import com.tzuhsien.taipeizoo.data.DefaultAppContainer
import timber.log.Timber
import kotlin.properties.Delegates

class ZooApplication : Application() {

    init {
        instance = this
    }
    companion object {
        var instance: ZooApplication by Delegates.notNull()

        fun applicationContext() : Context {
            return instance.applicationContext
        }
    }

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()

        // initialize timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}