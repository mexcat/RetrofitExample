package cl.gencina.retrofitexample.data

import androidx.lifecycle.LiveData
import cl.gencina.retrofitexample.data.local.TerrenoDao
import cl.gencina.retrofitexample.data.local.TerrenoEntity
import cl.gencina.retrofitexample.data.remote.TerrenoAPI

class Repositorio(private val terrenoAPI: TerrenoAPI, private val terrenoDao: TerrenoDao) {

    fun obtenerTerrenos():LiveData<List<TerrenoEntity>> = terrenoDao.getAll()

    suspend fun cargarTerreno() {
        val response = terrenoAPI.getData()
        if(response.isSuccessful){
            val resp = response.body()
            resp?.let {terrenos ->
            val terrenosEntity = terrenos.map {
                    it.transformaraEntity()
                }
                terrenoDao.insertList(terrenosEntity)
            }
        }
    }
    fun getTerreno(id:String) : LiveData<TerrenoEntity> = terrenoDao.getTerreno(id)

}
