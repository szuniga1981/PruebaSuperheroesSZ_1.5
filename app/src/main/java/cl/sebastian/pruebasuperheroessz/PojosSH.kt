package cl.sebastian.pruebasuperheroessz

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "superHeroes")
data class Heroes (@PrimaryKey val id:Int, val name:String, @Embedded val images:Img,
                   @Embedded val biography:Biografia, @Embedded val powerstats:PowerStats,@Embedded val appearance:Appearance)
data class Img (val lg:String)
data class PowerStats(val intelligence:Int,val strength:Int, val speed:Int, val durability :Int, val power:Int, val combat:Int)
data class Biografia(val fullName:String)
data class Appearance(val height:List<String>)



@Dao
interface HeroesDao{

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertHeroes(lista:List<Heroes>)


   @Query("SELECT * FROM superHeroes")
   fun getHeroes(): LiveData<List<Heroes>>

   @Query("SELECT * FROM superHeroes where id=:code")
   fun getHeroesDetail(code: Int):LiveData<Heroes>

}
@Database(entities = [Heroes::class],version=1)
@TypeConverters(Coverters::class)
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

