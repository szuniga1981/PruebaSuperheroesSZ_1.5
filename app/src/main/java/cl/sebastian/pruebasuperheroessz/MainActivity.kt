package cl.sebastian.pruebasuperheroessz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.sebastian.pruebasuperheroessz.databinding.ActivityMainBinding

/*
Herramientas
[x] ROOM como gestor de datos.
[x] Retrofit para consumir una REST API.
[x] LiveData para propagar los cambios.
[x] Recyclerview para mostrar los superhéroes.

Usar
[x]MVVM
[x] Repository
[]Dao
[] Factory

HITO 1


1[x]. Crear un proyecto para Kotlin y definir el nombre de la app.
2.[x] Agregar el permiso de Internet al manifiesto.

3.[x] Agregar ROOM como dependencia.
4.[] Definir la Data Class de nombre SuperheroCharacter que va a servir como entidad de la
DB. Esta misma clase puede ser utilizada para procesar la respuesta de la API dada la
naturaleza del problema.
5.[] Definir la interfaz Dao para obtener y guardar los personajes.
6.[] Agregar la clase que extiende de RoomDatabase y que será construida por
Room.databaseBuilder.
7.[]Crear la función getDatabase que permita obtener una instancia única de la BD. Una
forma de hacerlo es usando el patrón Singleton.
8.[] Agregar Retrofit como dependencia. Para convertir JSON una alternativa es utilizar
Gson agregando la dependencia.
9.[] Crear la interfaz para consumir la API REST que tiene los superhéroes. El endpoint que
se va a utilizar es /all.json para obtener la lista completa de superhéroes.
10.[] Crear la implementación para utilizar Retrofit. La forma recomendada es utilizar un
factory que devuelve la instancia del servicio a utilizar.
11.[] Crear el repositorio (la clase que implementa el patrón Repository) que permite
acceder y actualizar los datos. Para esto se debe:
[]Exponer la información de la DB usando DAO y LiveData.
[]Una función que permita actualizar la lista de superheroes desde la API.

 */

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
val viewModel:SuperHeroVM by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val adapter=HeroAdapter()
        binding.rvSuperhero.adapter=adapter
        binding.rvSuperhero.layoutManager=LinearLayoutManager(this)
        viewModel.superList.observe(this,{list->list?.let {
            adapter.updateList(it)}
        })
        setContentView(binding.root)
    }
}