package cl.gencina.retrofitexample.data

import cl.gencina.retrofitexample.data.local.TerrenoEntity
import cl.gencina.retrofitexample.data.remote.Terreno

fun Terreno.transformaraEntity(): TerrenoEntity = TerrenoEntity(this.id,this.precio, this.tipo, this.img)
