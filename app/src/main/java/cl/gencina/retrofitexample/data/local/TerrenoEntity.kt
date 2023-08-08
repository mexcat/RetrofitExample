package cl.gencina.retrofitexample.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "terreno_table")
data class TerrenoEntity(
    @PrimaryKey var id: String,
    val precio: Int,
    val tipo: String,
    val img: String
)