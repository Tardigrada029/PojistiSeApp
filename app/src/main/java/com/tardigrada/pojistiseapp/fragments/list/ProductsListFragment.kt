package com.tardigrada.pojistiseapp.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tardigrada.pojistiseapp.R

class ProductsListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_products_list, container, false)

        val floatBtnAddProduct = view.findViewById<FloatingActionButton>(R.id.floatBtnAddProduct)
        floatBtnAddProduct.setOnClickListener {
            findNavController().navigate(R.id.action_productsListFragment_to_productAddFragment)
        }

        return view
    }
}