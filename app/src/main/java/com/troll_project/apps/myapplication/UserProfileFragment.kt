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
import com.troll_project.apps.myapplication.databinding.FragmentUserProfileBinding


class UserProfileFragment : Fragment() {

   lateinit var binding: FragmentUserProfileBinding
   lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_profile, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        binding.userNameText.text = "Logged in as "+auth.currentUser?.email
        binding.bridge.setOnClickListener {
            findNavController().navigate(R.id.action_userProfileFragment_to_bridgesFragment)
        }
        binding.paymentButton.setOnClickListener {
            auth.signOut()
            findNavController().popBackStack(R.id.homepage, false)
        }
    }
}