package cl.sebastian.pruebasuperheroessz

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private const val BASE_URL = "https://akabab.github.io/superhero-api/api/"

        fun retrofitCliente(): SuperApi {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).build()

            return retrofit.create(SuperApi::class.java)
        }
    }
}