package com.tardigrada.pojistiseapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tardigrada.pojistiseapp.R
import com.tardigrada.pojistiseapp.entities.Product

class ProductListAdapter: RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    private var productList = emptyList<Product>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvProductName = itemView.findViewById<TextView>(R.id.tvProductName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return ProductListAdapter.MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.tvProductName.text = currentItem.productName
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun setData(product: List<Product>) {
        this.productList = product
        notifyDataSetChanged()
    }
}