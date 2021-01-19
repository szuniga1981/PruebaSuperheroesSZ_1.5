package cl.sebastian.pruebasuperheroessz

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "superHeroes")
data class Heroes (@PrimaryKey val id:Int, val name:String, @Embedded val images:Img)
data class Img (val lg:String)

@Dao
interface HeroesDao{

   @Insert
   suspend fun insertHeroes(lista:List<Heroes>)


   @Query("SELECT * FROM superHeroes")
   fun getHeroes(): LiveData<List<Heroes>>

}
@Database(entities = [Heroes::class],version=1)
abstract  class Superdatabase:RoomDatabase(){
   abstract  fun heroesDao():HeroesDao

}
class SuperApplication:Application(){
   companion object{
      var superDataBase:Superdatabase?=null

   }

   override fun onCreate() {
      super.onCreate()
      superDataBase=Room.databaseBuilder(this,Superdatabase::class.java,"super_db").build()
   }
}

