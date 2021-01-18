package cl.sebastian.pruebasuperheroessz

import retrofit2.Response
import retrofit2.http.GET

interface SuperApi {
    @GET("all.json")
    suspend fun  getHeros(): Response<List<Heroes>>



}