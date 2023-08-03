package cl.gencina.retrofitexample.data.remote

import com.google.gson.annotations.SerializedName


data class Terreno(
    val id: String,
    @SerializedName("price") val precio: Int,
    @SerializedName("type") val tipo: String,
    @SerializedName("img_src") val img: String
)

