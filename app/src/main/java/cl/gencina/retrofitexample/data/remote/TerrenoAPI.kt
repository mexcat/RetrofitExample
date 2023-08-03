package cl.gencina.retrofitexample.data.remote

import cl.gencina.retrofitexample.data.remote.Terreno
import retrofit2.Response
import retrofit2.http.GET

interface TerrenoAPI {

    @GET("realestate")
    suspend fun getData(): Response<List<Terreno>>

}