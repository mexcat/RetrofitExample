package cl.gencina.retrofitexample.data

import android.util.Log
import cl.gencina.retrofitexample.data.remote.Terreno
import cl.gencina.retrofitexample.data.remote.TerrenoAPI

class Repositorio(private val terrenoAPI: TerrenoAPI) {

    suspend fun cargarTerreno(): List<Terreno> {
        val response = terrenoAPI.getData()
        if(response.isSuccessful){
            val resp = response.body()
            resp?.let {
                Log.e("it", it.toString())
                return it
            }
        }
        return emptyList()
    }

}