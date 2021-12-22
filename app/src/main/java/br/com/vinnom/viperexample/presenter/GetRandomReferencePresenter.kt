package br.com.vinnom.viperexample.presenter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import br.com.vinnom.domain.entity.AnimeReferenceEntity
import br.com.vinnom.interactor.RandomReferenceInteractor
import br.com.vinnom.viperexample.utils.isInternetAvailable
import br.com.vinnom.viperexample.view.GetRandomReferenceFragmentView

class GetRandomReferencePresenter(val view: GetRandomReferenceFragmentView) {

    fun getRandomReferenceButtonClicked() {
        Log.d(
            "ViperExample",
            "getRandomReferenceButtonClicked: button was clicked"
        )

        if (isInternetAvailable(view as Fragment)) {
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
}