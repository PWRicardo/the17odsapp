package com.example.the17odsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.the17odsapp.databinding.FragmentRegisterDataBinding

class RegisterDataFragment : Fragment() {

    val args : RegisterDataFragmentArgs by navArgs()

    private var _binding : FragmentRegisterDataBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRegisterDataBinding.inflate(inflater, container, false)

        val view = binding.root

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonRegistrarDatos.setOnClickListener {
            val theAction = RegisterDataFragmentDirections.actionRegisterDataFragmentToUserPerfilFragment(args.correo, args.password)
             it.findNavController().navigate(theAction)
        }

    }
}