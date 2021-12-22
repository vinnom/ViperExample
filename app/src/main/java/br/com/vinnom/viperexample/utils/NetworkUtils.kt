package br.com.vinnom.viperexample.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.fragment.app.Fragment

fun isInternetAvailable(view: Fragment): Boolean {
    val cm =
        view.context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkCapabilities = cm.getNetworkCapabilities(cm.activeNetwork)

    val capabilities = (networkCapabilities != null
            && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET))
    Log.d("ViperExample", "isInternetAvailable: $capabilities")
    return capabilities
}