package com.troll_project.apps.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.troll_project.apps.myapplication.databinding.FragmentBridgesBinding


class BridgesFragment : Fragment() {
    lateinit var binding: FragmentBridgesBinding
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth= FirebaseAuth.getInstance()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_bridges,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bhairav.setOnClickListener {
            findNavController().navigate(R.id.action_bridgesFragment_to_bhairavFragment)
        }
        binding.jamuna.setOnClickListener {
            findNavController().navigate(R.id.action_bridgesFragment_to_jamunaFragment)
        }
        binding.mawa.setOnClickListener {
            findNavController().navigate(R.id.action_bridgesFragment_to_mawaFragment2)
        }
        binding.meghna.setOnClickListener {
            findNavController().navigate(R.id.action_bridgesFragment_to_meghnaFragment)
        }
        binding.padma.setOnClickListener {
            findNavController().navigate(R.id.action_bridgesFragment_to_padmaFragment2)
        }
    }


}