package br.com.vinnom.interactor.webapi

import br.com.vinnom.interactor.webapi.service.RandomReferenceService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://animechan.vercel.app/api/"

class RetrofitConfig() {

    private var _retrofit: Retrofit? = null
    val retrofit get() = _retrofit!!

    init {
        val okHttpClient = configureOkHttpClient()

        if (_retrofit == null) {
            _retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient).build()
        }
    }

    private fun configureOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor = interceptor).build()
        return okHttpClient
    }

    fun getRandomReferenceService(): RandomReferenceService {
        return retrofit.create(RandomReferenceService::class.java)
    }
}