package com.tzuhsien.taipeizoo.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.tzuhsien.taipeizoo.ZooApplication
import com.tzuhsien.taipeizoo.ZooApplication.Companion.applicationContext

object Util {
    /**
     * Determine and monitor the connectivity status
     */
    fun isInternetConnected(): Boolean {
        val cm = ZooApplication.instance
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }

    fun getString(resourceId: Int, value: String? = null): String {

        return applicationContext().getString(resourceId, value)
    }
}