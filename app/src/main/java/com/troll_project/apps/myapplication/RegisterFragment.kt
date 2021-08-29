package com.troll_project.apps.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.troll_project.apps.myapplication.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    lateinit var binding: FragmentRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButton.setOnClickListener {
            register()
        }

        binding.navigateToLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment2_to_loginFragment)
        }
    }

    fun register() {
        val email = binding.email.text.toString().trim()
        val password = binding.password.text.toString().trim()

        if (!email.isBlank() && !password.isBlank()) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(requireContext(), "Successful", Toast.LENGTH_SHORT).show()
                        val user = auth.currentUser
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(requireContext(),
                "Email and password both required", Toast.LENGTH_SHORT).show()
        }
    }

}