package com.example.the17odsapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.the17odsapp.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegisterFragment : Fragment() {
    private lateinit var auth : FirebaseAuth

    private var _binding: FragmentRegisterBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView ( inflater: LayoutInflater, container: ViewGroup?, saveInstanceState: Bundle?): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)


        auth = Firebase.auth

        val view = binding.root

        return view
    }

    private fun createAccount( email:String, password:String) {

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this) { task ->
            if(task.isSuccesful){

                val user = auth.currentUser
                updateUI(user)
            } else {
                Toast.makeText(context!!.applicationContext, "Registro fallido.", Toast.LENGTH_SHORT).show()
                updateUI(null)
            }
        }
    }

    private fun updateUI(user: FirebaseUser?) {

    }

}