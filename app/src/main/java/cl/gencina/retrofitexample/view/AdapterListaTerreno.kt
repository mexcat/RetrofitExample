package cl.gencina.retrofitexample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.gencina.retrofitexample.data.remote.Terreno
import cl.gencina.retrofitexample.databinding.TerrenosItemBinding
import coil.load
import coil.transform.CircleCropTransformation

class AdapterListaTerreno : RecyclerView.Adapter<AdapterListaTerreno.ListaTerrenoViewHolder>() {

    lateinit var binding : TerrenosItemBinding
    private val listaTerrenos = mutableListOf<Terreno>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaTerrenoViewHolder {
        binding = TerrenosItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListaTerrenoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListaTerrenoViewHolder, position: Int) {
        val terreno = listaTerrenos[position]
        holder.bind(terreno)
    }

    override fun getItemCount(): Int {
        return listaTerrenos.size
    }

    fun setData(listaTerrenos: List<Terreno>){
        this.listaTerrenos.clear()
        this.listaTerrenos.addAll(listaTerrenos)
        notifyDataSetChanged()

    }

    class ListaTerrenoViewHolder(private val v: TerrenosItemBinding):RecyclerView.ViewHolder(v.root) {
        fun bind(terreno: Terreno) {
            v.ivTerreno.load(terreno.img){
                transformations(CircleCropTransformation())
            }
        }
    }
}

