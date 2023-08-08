package cl.gencina.retrofitexample.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface TerrenoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item : TerrenoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(item : List<TerrenoEntity>)

    @Query("SELECT * FROM terreno_table ORDER BY id ASC")
    fun getAll(): LiveData<List<TerrenoEntity>>

    @Delete
    fun delete(items: List<TerrenoEntity>)
    @Query("Select * from terreno_table where id = :id")
    fun getTerreno(id:String): LiveData<TerrenoEntity>

}