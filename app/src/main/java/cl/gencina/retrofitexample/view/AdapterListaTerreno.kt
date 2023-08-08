package cl.gencina.retrofitexample.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.gencina.retrofitexample.R
import cl.gencina.retrofitexample.data.local.TerrenoEntity
import cl.gencina.retrofitexample.databinding.TerrenosItemBinding
import coil.load
import coil.transform.CircleCropTransformation

class AdapterListaTerreno : RecyclerView.Adapter<AdapterListaTerreno.ListaTerrenoViewHolder>() {

    lateinit var binding : TerrenosItemBinding
    private val listaTerrenos = mutableListOf<TerrenoEntity>()

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

    fun setData(listaTerrenos: List<TerrenoEntity>){
        this.listaTerrenos.clear()
        this.listaTerrenos.addAll(listaTerrenos)
        notifyDataSetChanged()

    }

    class ListaTerrenoViewHolder(private val v: TerrenosItemBinding):RecyclerView.ViewHolder(v.root) {
        fun bind(terreno: TerrenoEntity) {
            v.ivTerreno.load(terreno.img){
                transformations(CircleCropTransformation())
            }
            v.cvTerreno.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("idTerreno", terreno.id)
                Navigation.findNavController(v.root).navigate(R.id.action_listaTerrenoFragment_to_detalleFragment, bundle)
            }
        }
    }
}

