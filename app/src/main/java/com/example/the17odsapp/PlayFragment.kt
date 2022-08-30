package com.example.the17odsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.the17odsapp.databinding.FragmentPlayBinding

class PlayFragment : Fragment() {

    public var puntuacionLocal = 0

    private var _binding : FragmentPlayBinding? = null

    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels { MainViewModelFactory(puntuacionLocal) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayBinding.inflate(inflater, container,false)

        val view = binding.root

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textViewPuntuacionPlay.text = viewModel.puntuacion.toString()

        viewModel.puntuacion.observe(viewLifecycleOwner) { puntuacionVM ->
            binding.buttonSiguientePlay.setOnClickListener {
                viewModel.incremento()
                //puntuacionLocal = (puntuacionVM + 1)

                binding.textViewPuntuacionPlay.text = puntuacionVM.toString()

            }
        }



    }
}