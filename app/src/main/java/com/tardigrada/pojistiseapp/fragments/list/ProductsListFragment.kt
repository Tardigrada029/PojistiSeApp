package com.tardigrada.pojistiseapp.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tardigrada.pojistiseapp.R
import com.tardigrada.pojistiseapp.entities.viewModels.ProductViewModel
import com.tardigrada.pojistiseapp.entities.viewModels.UserViewModel

class ProductsListFragment : Fragment() {

    private lateinit var mProductViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_products_list, container, false)

        // variables
        val rvProductsList = view.findViewById<RecyclerView>(R.id.rvProductsList)

        // recyclerView
        val adapter = ProductListAdapter()
        rvProductsList.adapter = adapter
        rvProductsList.layoutManager = LinearLayoutManager(requireContext())

        // ProductViewModel
        mProductViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        mProductViewModel.readAllData().observe(viewLifecycleOwner, Observer { product ->
            adapter.setData(product)
        })

        val floatBtnAddProduct = view.findViewById<FloatingActionButton>(R.id.floatBtnAddProduct)
        floatBtnAddProduct.setOnClickListener {
            findNavController().navigate(R.id.action_productsListFragment_to_productAddFragment)
        }

        return view
    }
}