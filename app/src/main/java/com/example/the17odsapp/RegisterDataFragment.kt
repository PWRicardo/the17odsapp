package com.example.the17odsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.the17odsapp.databinding.FragmentRegisterDataBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RegisterDataFragment : Fragment() {

    private lateinit var database : DatabaseReference

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

        database = Firebase.database.getReference("Users")


        binding.buttonRegistrarDatos.setOnClickListener {

            val nombre = binding.editTextNombreComp.text.toString()
            val nickname = binding.editTextNickname.text.toString()
            val email  = args.correo
            val calle = binding.EditextCalle.text.toString()
            val nExterior = binding.EditextNExterior.text.toString()
            val cPostal = binding.EditextCp.text.toString()
            val colonia = binding.EditextColonia.text.toString()
            val ciudad = binding.EditextCiudad.text.toString()
            val estado = binding.EditextEstado.text.toString()
            val pais = binding.EditextPais.text.toString()

            val theUserHas = User(nombre, nickname, email, calle, nExterior, cPostal, colonia, ciudad, estado, pais)

            database.child(nickname).setValue(theUserHas).addOnSuccessListener {
                Toast.makeText(context, "Bienvenido", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{
                Toast.makeText(context, "Fallo ocurrido", Toast.LENGTH_LONG).show()
            }
            val theAction = RegisterDataFragmentDirections.actionRegisterDataFragmentToUserPerfilFragment(nickname, args.password)
             it.findNavController().navigate(theAction)
        }

    }
}