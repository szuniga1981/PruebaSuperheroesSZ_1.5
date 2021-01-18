package cl.sebastian.pruebasuperheroessz

import android.util.Log

import androidx.lifecycle.MutableLiveData

class SuperHeroRepository {

    val superList = MutableLiveData<List<Heroes>>()


    suspend fun getSuperHeroFromApi(){


        val response = RetrofitClient.retrofitCliente().getHeros()




        when (response.isSuccessful) {
            true -> {
                response.body()?.let {
                    superList.value = it
                    Log.d("Repo-getSuperHero", "getSuperHeroFromApi con :${it.size} Heroes")
                }

            }
            false -> {
                Log.d("Repo-getSuperHero,", "getSuperHeroFromApi: ${response.errorBody()}")

            }
        }

    }
}
