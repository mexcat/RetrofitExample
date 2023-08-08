package cl.gencina.retrofitexample.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.gencina.retrofitexample.databinding.FragmentListaTerrenoBinding


class ListaTerrenoFragment : Fragment() {
    lateinit var binding : FragmentListaTerrenoBinding
    val viewmodel : TerrenoViewModel by activityViewModels()
    private var param1: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getBoolean("volver")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaTerrenoBinding.inflate(layoutInflater, container, false)

        if(param1 == true){
            start()
        }

        binding.btnObtenerLista.setOnClickListener {
            start()
        }
        return binding.root
    }

    private fun start(){
        initAdapter()
        viewmodel.getTerrenos()
    }
    private fun initAdapter(){
        val adapter = AdapterListaTerreno()
        binding.rvListaTerrenos.adapter = adapter
        viewmodel.terrenosLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }
}