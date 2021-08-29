package com.troll_project.apps.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.troll_project.apps.myapplication.databinding.FragmentHomepage2Binding

class Homepage : Fragment() {

    lateinit var binding: FragmentHomepage2Binding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()

        if (auth.currentUser != null) {
            findNavController().navigate(R.id.action_homepage_to_userProfileFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage2, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homepage_to_loginFragment)
        }

        binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_homepage_to_registerFragment2)
        }
    }


}