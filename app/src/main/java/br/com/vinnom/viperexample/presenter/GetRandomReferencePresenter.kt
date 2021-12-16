package br.com.vinnom.viperexample.presenter

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import br.com.vinnom.domain.entity.AnimeReferenceEntity
import br.com.vinnom.interactor.RandomReferenceInteractor
import br.com.vinnom.viperexample.view.GetRandomReferenceFragmentView

class GetRandomReferencePresenter(val view: GetRandomReferenceFragmentView) {

    fun getRandomReferenceButtonClicked() {
        Log.d(
            "ViperExample",
            "getRandomReferenceButtonClicked: button was clicked"
        )



        if (isInternetAvailable()) {
            val animeReferenceLiveData = liveData<AnimeReferenceEntity?> {
                val randomReference = RandomReferenceInteractor().getRandomReference()
                emit(randomReference)
            }

            animeReferenceLiveData.observe(view, Observer { animeReferenceEntity ->
                animeReferenceEntity?.let {
                    Log.d("ViperExample", "anime reference != null")
                } ?: also { Log.d("ViperExample", "anime reference == null") }
            })

        }
    }

    private fun isInternetAvailable(): Boolean {
        val cm = view.context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = cm.getNetworkCapabilities(cm.activeNetwork)

        val capabilities = (networkCapabilities != null
                && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET))
        Log.d("ViperExample", "isInternetAvailable: $capabilities")
        return capabilities
    }
}