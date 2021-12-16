package br.com.vinnom.interactor

import br.com.vinnom.domain.entity.AnimeReferenceEntity
import br.com.vinnom.interactor.webapi.RetrofitConfig

private const val NULL_BODY = "null"

class RandomReferenceInteractor {

    suspend fun getRandomReference(): AnimeReferenceEntity? {
        val service = RetrofitConfig().getRandomReferenceService()

        val randomReference = service.getRandomReference()
        if (randomReference.isSuccessful) {
            return if (randomReference.body() != null) {
                randomReference.body()
            } else {
                AnimeReferenceEntity(NULL_BODY, NULL_BODY, NULL_BODY)
            }
        }
        return AnimeReferenceEntity(NULL_BODY, NULL_BODY, NULL_BODY)
    }
}