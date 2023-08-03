package cl.gencina.retrofitexample.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.gencina.retrofitexample.data.Repositorio
import cl.gencina.retrofitexample.data.remote.Terreno
import cl.gencina.retrofitexample.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoViewModel(application: Application) : AndroidViewModel(application){
    private val repositorio:Repositorio
    val terrenosLiveData = MutableLiveData<List<Terreno>>()

    init {
        val api = TerrenoRetroFit.getRetrofitTerreno()
        repositorio = Repositorio(api)
    }

    fun getTerrenos() = viewModelScope.launch{
        terrenosLiveData.value = repositorio.cargarTerreno()
    }

}