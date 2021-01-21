package cl.sebastian.pruebasuperheroessz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SuperHeroVM: ViewModel() {



    val repository=SuperHeroRepository()
val superList = repository.superList
    val detailHero=repository.detailHero
private val detail=MutableLiveData<Heroes>()


    init {
        viewModelScope.launch {
            repository.getSuperHeroFromApi()
        }

    }
    private lateinit var seledtedHeroes:Heroes



    fun setSelected(heroes:Heroes)  {

         seledtedHeroes=heroes
       }
    fun getDetail() : LiveData<Heroes>{
        return repository.getHeroes(seledtedHeroes.id)
    }
    }

