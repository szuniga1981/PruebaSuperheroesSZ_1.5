package cl.sebastian.pruebasuperheroessz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SuperHeroVM: ViewModel() {
    fun doSomething(){

    }

    val repository=SuperHeroRepository()
val superList = repository.superList

    init {
        viewModelScope.launch {
            repository.getSuperHeroFromApi()
        }

    }
}