package com.example.the17odsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.the17odsapp.databinding.FragmentResetPwdBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ResetPwdFragment : Fragment() {

    private lateinit var auth:FirebaseAuth

    private var _binding: FragmentResetPwdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResetPwdBinding.inflate(inflater, container, false)

        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth

        binding.buttonRecuperarCont.setOnClickListener {
            val correoToRecuperar = binding.editTextCorreoRecuperar.text.toString()

            sendPasswordReset(correoToRecuperar)

        }
    }

    private fun sendPasswordReset(email: String) {
        Toast.makeText(context, "entro a sendPwd", Toast.LENGTH_LONG).show()
        Firebase.auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
            if(task.isSuccessful) {
                Toast.makeText(context, "Verifica tu correo", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(context, "vuelve a intentarlo", Toast.LENGTH_LONG).show()
            }
        }
    }






}