package br.com.vinnom.interactor

import br.com.vinnom.domain.entity.AnimeReferenceEntity
import br.com.vinnom.interactor.webapi.RetrofitConfig
import br.com.vinnom.interactor.webapi.model.AnimeReferenceData

private const val NULL_BODY = "null"

class RandomReferenceInteractor {

    suspend fun getRandomReference(): AnimeReferenceEntity? {
        val service = RetrofitConfig().getRandomReferenceService()

        val randomReference = service.getRandomReference()
        if (randomReference.isSuccessful) {
            return if (randomReference.body() != null) {
                maptoEntity(randomReference.body() as AnimeReferenceData)
            } else {
                AnimeReferenceEntity(NULL_BODY, NULL_BODY, NULL_BODY)
            }
        }
        return AnimeReferenceEntity(NULL_BODY, NULL_BODY, NULL_BODY)
    }

    private fun maptoEntity(data: AnimeReferenceData): AnimeReferenceEntity {
        return AnimeReferenceEntity(data.anime, data.character, data.quote)
    }
}