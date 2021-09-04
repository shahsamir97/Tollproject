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
import com.troll_project.apps.myapplication.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth

    public override fun onStart() {
        super.onStart()
        auth = FirebaseAuth.getInstance()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            hideKeyboard(requireActivity())

            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()
            if (!email.isBlank() && !password.isBlank()) {
                loginuser(email, password)
            }else{
                Toast.makeText(requireContext(), "Email and password both required", Toast.LENGTH_SHORT).show()
            }
        }

        binding.navigateToRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment2)
        }
    }

    fun loginuser(email: String, password: String) {
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {

                Toast.makeText(requireContext(), "Successful", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_loginFragment_to_userProfileFragment)

            }.addOnFailureListener {
                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
            }
    }

}