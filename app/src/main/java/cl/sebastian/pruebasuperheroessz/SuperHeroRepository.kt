package cl.sebastian.pruebasuperheroessz

import android.util.Log
import androidx.lifecycle.LiveData

class SuperHeroRepository {

    // val superList = MutableLiveData<List<Heroes>>()
    //val database=SuperApplication.superDataBase!!
    private val heroesDao = SuperApplication.superDataBase!!.heroesDao()
    val superList = heroesDao.getHeroes()
    val detailHero = heroesDao.getHeroes()

    suspend fun getSuperHeroFromApi() {


        val response = RetrofitClient.retrofitCliente().getHeros()



        when (response.isSuccessful) {
            true -> {
                response.body()?.let {
                    heroesDao.insertHeroes(it)
                    Log.d("Repo-getSuperHero", "getSuperHeroFromApi con :${it.size} Heroes")
                }

            }
            false ->
                Log.d("Repo-getSuperHero,", "getSuperHeroFromApi: ${response.errorBody()}")

        }
    }
        fun getHeroes(code: Int): LiveData<Heroes> {
            return heroesDao.getHeroesDetail(code)
        }
    }



