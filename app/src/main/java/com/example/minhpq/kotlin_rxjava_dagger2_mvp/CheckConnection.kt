package com.example.minhpq.kotlin_rxjava_dagger2_mvp

import android.content.Context
import android.net.ConnectivityManager



class CheckConnection {
    companion object {
        fun isOnline(baseContext: Context): Boolean {
            val cm = baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            return netInfo != null && netInfo.isConnectedOrConnecting
        }
    }
}