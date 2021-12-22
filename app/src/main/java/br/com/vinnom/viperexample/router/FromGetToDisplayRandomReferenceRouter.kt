package br.com.vinnom.viperexample.router

import br.com.vinnom.domain.entity.AnimeReferenceEntity
import br.com.vinnom.viperexample.R
import br.com.vinnom.viperexample.view.DisplayRandomReferenceFragmentView
import br.com.vinnom.viperexample.view.GetRandomReferenceFragmentView

fun routeWithSuccess(
    animeReferenceEntity: AnimeReferenceEntity,
    view: GetRandomReferenceFragmentView
) {
    view.parentFragmentManager.apply {
        beginTransaction()
            .addToBackStack(null)
            .replace(
                R.id.fragment_container_view,
                DisplayRandomReferenceFragmentView(animeReferenceEntity)
            )
            .setReorderingAllowed(true)
            .commit()
    }

}