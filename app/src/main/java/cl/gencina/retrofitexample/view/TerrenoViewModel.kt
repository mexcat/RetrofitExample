package cl.gencina.retrofitexample.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.gencina.retrofitexample.data.Repositorio
import cl.gencina.retrofitexample.data.local.TerrenoDatabase
import cl.gencina.retrofitexample.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoViewModel(application: Application) : AndroidViewModel(application){
    private val repositorio:Repositorio

    fun terrenosLiveData() = repositorio.obtenerTerrenos()


    init {
        val api = TerrenoRetroFit.getRetrofitTerreno()
        val database = TerrenoDatabase.getDatabase(application).TerrenoDao()
        repositorio = Repositorio(api, database)
    }

    fun getTerrenos() = viewModelScope.launch{
        repositorio.cargarTerreno()
    }

    fun terrenosLiveData(id:String) = repositorio.getTerreno(id)

}