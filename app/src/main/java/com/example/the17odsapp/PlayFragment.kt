package com.example.the17odsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.the17odsapp.databinding.FragmentPlayBinding

class PlayFragment : Fragment() {

    public var puntuacionLocal = 0

    private var _binding : FragmentPlayBinding? = null

    private val binding get() = _binding!!

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

        binding.buttonSiguientePlay.setOnClickListener {
            puntuacionLocal += 1

            binding.textViewPuntuacionPlay.text = puntuacionLocal.toString()
        }

    }
}