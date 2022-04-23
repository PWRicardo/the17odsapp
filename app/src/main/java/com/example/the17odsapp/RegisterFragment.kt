package com.example.the17odsapp

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.the17odsapp.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegisterFragment : Fragment() {
    private lateinit var auth: FirebaseAuth

    private var _binding: FragmentRegisterBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)


        //auth = Firebase.auth

        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth
        binding.idvercontra.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // Acciones al estar activo
                Toast.makeText(context, "me active", Toast.LENGTH_SHORT).show()
                binding.editTextPwd.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                Toast.makeText(context, "me desactive", Toast.LENGTH_SHORT).show()
                binding.editTextPwd.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
         fun alerta(){
             val builder = AlertDialog.Builder(context)
             builder.setTitle("Error")
             builder.setMessage("Se ha producido un error con los datos ingresados")
             builder.setPositiveButton("Aceptar",null)
             val dialog: AlertDialog = builder.create()
             dialog.show()
        }

        binding.buttonRegistrar.setOnClickListener {
            if(binding.editTextEmail.text.isNotEmpty() && binding.editTextPwd.text.isNotEmpty()){
            val correo = binding.editTextEmail.text.toString()
            val pwd = binding.editTextPwd.text.toString()
            createAccount(correo, pwd, it)
            }else{
                alerta()
            }
        }

        binding.accederButton.setOnClickListener {
            if(binding.editTextEmail.text.isNotEmpty() && binding.editTextPwd.text.isNotEmpty()){
            val correo = binding.editTextEmail.text.toString()
            val pwd = binding.editTextPwd.text.toString()
            signIn(correo, pwd, it)
            }else{
                alerta()
            }
        }
    }

    private fun createAccount(email: String, password: String, view: View) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                    val theAction = RegisterFragmentDirections.actionRegisterFragmentToUserPerfilFragment(email,password)
                    view.findNavController().navigate(theAction)
                    //Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Registro fallido.", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    private fun signIn(email: String, password: String, view: View) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {

                    //Toast.makeText(context, "entraste bien", Toast.LENGTH_LONG).show()
                    val user = auth.currentUser

                    val theAction = RegisterFragmentDirections.actionRegisterFragmentToUserPerfilFragment(email, password)
                    view.findNavController().navigate(theAction)
                    updateUI(user)
                } else {
                    Toast.makeText(context, "entraste mal", Toast.LENGTH_LONG).show()
                    updateUI(null)
                }
            }
    }

    private fun updateUI(user: FirebaseUser?) {

    }

}