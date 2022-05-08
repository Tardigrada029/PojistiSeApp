package com.tardigrada.pojistiseapp.fragments.update

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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tardigrada.pojistiseapp.R
import com.tardigrada.pojistiseapp.entities.Product
import com.tardigrada.pojistiseapp.entities.viewModels.ProductViewModel
import com.tardigrada.pojistiseapp.entities.viewModels.UserViewModel

class ProductUpdateFragment : Fragment() {

    private val args by navArgs<ProductUpdateFragmentArgs>()

    private lateinit var mProductViewModel: ProductViewModel

    private lateinit var etUpdateProductName: EditText
    private lateinit var btnUpdateProduct: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_update, container, false)

        mProductViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        etUpdateProductName = view.findViewById(R.id.etUpdateProductName)
        btnUpdateProduct = view.findViewById(R.id.btnUpdateProduct)

        etUpdateProductName.setText(args.currentProduct.productName)

        btnUpdateProduct.setOnClickListener {
            updateItem()
        }

        return view
    }

    private fun updateItem() {
        // variables
        val productName = etUpdateProductName.text.toString()

        if (inputCheck(productName)) {
            // create product object
            val updatedProduct = Product(args.currentProduct.productId, productName)
            // update current product
            mProductViewModel.updateProduct(updatedProduct)
            Toast.makeText(requireContext(), "Produkt byl aktualizován.", Toast.LENGTH_SHORT).show()
            // navigate to the list of products
            findNavController().navigate(R.id.action_productUpdateFragment_to_productsListFragment)
        } else {
            Toast.makeText(requireContext(), "Prosím, vyplňte všechny údaje.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(productName: String): Boolean {
        return !(TextUtils.isEmpty(productName))
    }
}