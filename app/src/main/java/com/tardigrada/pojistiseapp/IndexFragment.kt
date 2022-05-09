package com.tardigrada.pojistiseapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class IndexFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_index, container, false)

        // variables
        val btnUsers = view.findViewById<Button>(R.id.btnUsers)
        val btnProducts = view.findViewById<Button>(R.id.btnProducts)
        // val btnInsurances = view.findViewById<Button>(R.id.btnInsurances)

        btnUsers.setOnClickListener {
            findNavController().navigate(R.id.action_indexFragment_to_usersListFragment)
        }

        btnProducts.setOnClickListener {
            findNavController().navigate(R.id.action_indexFragment_to_productsListFragment)
        }

        /*
        btnInsurances.setOnClickListener {
            findNavController().navigate(R.id.action_indexFragment_to_insurancesListFragment)
        }
        
         */

        return view
    }
}