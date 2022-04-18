package com.example.the17odsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.the17odsapp.databinding.FragmentUserPerfilBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class UserPerfilFragment : Fragment() {

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

        binding.buttonLogOut.setOnClickListener {
            signOut()
        }
    }

    private fun signOut() {
        auth.signOut()
    }

}