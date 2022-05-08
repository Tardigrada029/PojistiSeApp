package com.tardigrada.pojistiseapp.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.tardigrada.pojistiseapp.R
import com.tardigrada.pojistiseapp.entities.Product
import com.tardigrada.pojistiseapp.entities.viewModels.ProductViewModel
import com.tardigrada.pojistiseapp.entities.viewModels.UserViewModel
import kotlinx.coroutines.launch

class ProductAddFragment : Fragment() {

    private lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_add, container, false)

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        // variables
        val btnAddProduct = view.findViewById<Button>(R.id.btnAddProduct)

        btnAddProduct.setOnClickListener {
            insertProductDataToDatabase()
        }

        return view
    }

    private fun insertProductDataToDatabase() {
        // variables
        val etProductName = view?.findViewById<EditText>(R.id.etProductName)

        val productName = etProductName?.text.toString()

        if (inputCheck(productName)) {
            // create product object
            val product = Product(0,productName)
            // add data to the database
            saveProduct(product)
            Toast.makeText(requireContext(), "Produkt byl uložen do databáze.", Toast.LENGTH_LONG).show()
            // navigate back to the list
            findNavController().navigate(R.id.action_productAddFragment_to_productsListFragment)
        } else {
            Toast.makeText(requireContext(), "Prosím, vyplňte všechny údaje.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(productName: String): Boolean {
        return !(TextUtils.isEmpty(productName))
    }

    private fun saveProduct(product: Product) {
        lifecycleScope.launch {
            productViewModel.addProduct(product)
        }
    }
}