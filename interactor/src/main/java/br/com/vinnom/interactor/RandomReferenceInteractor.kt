package br.com.vinnom.interactor

import br.com.vinnom.domain.entity.AnimeReferenceEntity
import br.com.vinnom.webapi.RetrofitConfig
import br.com.vinnom.webapi.entity.RandomReferenceWebEntity
import retrofit2.Response

class RandomReferenceInteractor {

    suspend fun getRandomReference(): AnimeReferenceEntity? {
        val service = RetrofitConfig().getRandomReferenceService()

        val randomReference = service.getRandomReference()
        if (randomReference.isSuccessful) {
            return mapToAnimeReferenceEntity(randomReference)
        }
        return null
    }

    private fun mapToAnimeReferenceEntity(randomReference: Response<RandomReferenceWebEntity>): AnimeReferenceEntity? {
        return randomReference.body()?.let { webEntity ->
            AnimeReferenceEntity(
                webEntity.animeName,
                webEntity.characterName,
                webEntity.quote
            )
        }
    }
}