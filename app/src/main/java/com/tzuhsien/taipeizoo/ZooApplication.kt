package com.tzuhsien.taipeizoo

import android.app.Application
import com.tzuhsien.taipeizoo.data.AppContainer
import com.tzuhsien.taipeizoo.data.DefaultAppContainer

class ZooApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}