package com.curriculumvitae.android.utils

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class NetworkUtils @Inject constructor() {

    fun isConnected(context: Context): Boolean {
        val mManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val current = mManager.activeNetworkInfo
        return current != null && current.isConnectedOrConnecting
    }
}