package cl.gencina.retrofitexample.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import cl.gencina.retrofitexample.R
import cl.gencina.retrofitexample.databinding.FragmentDetalleBinding
import coil.load

class DetalleFragment : Fragment() {

    private lateinit var binding: FragmentDetalleBinding
    private val terrenosViewModel: TerrenoViewModel by activityViewModels()
    private var param1: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("idTerreno")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
     ): View? {
        binding = FragmentDetalleBinding.inflate(layoutInflater, container, false)

        terrenosViewModel.terrenosLiveData(param1.toString()).observe(viewLifecycleOwner){
            binding.ivTerreno.load(it.img)
            binding.tvId.text = "Id terreno : " + it.id
            binding.tvTipo.text = "Tipo : " + it.tipo
            binding.tvPrecio.text = "Precio : " + it.precio.toString()
        }

        binding.btnVolver.setOnClickListener {
            val bundle = Bundle()
            bundle.putBoolean("volver", true)
            Navigation.findNavController(binding.root).navigate(R.id.action_detalleFragment_to_listaTerrenoFragment, bundle)
        }

        return binding.root
    }

}