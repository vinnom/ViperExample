package br.com.vinnom.webapi.service

import br.com.vinnom.webapi.entity.RandomReferenceWebEntity
import retrofit2.Response
import retrofit2.http.GET

interface RandomReferenceService {

    @GET(value = "random")
    suspend fun getRandomReference(): Response<RandomReferenceWebEntity>

}
