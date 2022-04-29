package com.example.the17odsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.the17odsapp.databinding.FragmentUserPerfilBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class UserPerfilFragment : Fragment() {

    val args: UserPerfilFragmentArgs by navArgs()

    private lateinit var auth: FirebaseAuth

    private var _binding: FragmentUserPerfilBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView (inflater: LayoutInflater, container: ViewGroup?, saveInstanceState: Bundle?): View {
        _binding = FragmentUserPerfilBinding.inflate(inflater, container, false)

        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth

        binding.textViewUserEmail.text = args.correo

        binding.buttonLogOut.setOnClickListener {
            signOut(it)
        }
        binding.buttonEditPerfil.setOnClickListener {
            val theAction =
        }
    }

    private fun signOut(view: View) {
        auth.signOut()
        val theAction = UserPerfilFragmentDirections.actionUserPerfilFragmentToRegisterFragment()

        view.findNavController().navigate(theAction)
    }

}