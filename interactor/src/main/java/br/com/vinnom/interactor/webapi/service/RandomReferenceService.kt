package br.com.vinnom.interactor.webapi.service

import br.com.vinnom.domain.entity.AnimeReferenceEntity
import retrofit2.Response
import retrofit2.http.GET

interface RandomReferenceService {

    @GET(value = "random")
    suspend fun getRandomReference(): Response<AnimeReferenceEntity>

}
