package cl.gencina.retrofitexample.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.trace
import androidx.fragment.app.activityViewModels
import cl.gencina.retrofitexample.data.remote.Terreno
import cl.gencina.retrofitexample.databinding.FragmentListaTerrenoBinding


class ListaTerrenoFragment : Fragment() {
    lateinit var binding : FragmentListaTerrenoBinding
    val viewmodel : TerrenoViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaTerrenoBinding.inflate(layoutInflater, container, false)
        initAdapter()
        binding.btnObtenerLista.setOnClickListener {
            viewmodel.getTerrenos()
        }
        return binding.root
    }

    private fun initAdapter(){
        val adapter = AdapterListaTerreno()
        binding.rvListaTerrenos.adapter = adapter
        viewmodel.terrenosLiveData.observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }
}