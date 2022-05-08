package com.tardigrada.pojistiseapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tardigrada.pojistiseapp.R
import com.tardigrada.pojistiseapp.entities.User

class UserListAdapter: RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvUserFirstName = itemView.findViewById<TextView>(R.id.tvUserFirstName)
        val tvUserLastName = itemView.findViewById<TextView>(R.id.tvUserLastName)
        val tvUserEmail = itemView.findViewById<TextView>(R.id.tvUserEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.tvUserFirstName.text = currentItem.firstName
        holder.tvUserLastName.text = currentItem.lastName
        holder.tvUserEmail.text = currentItem.email
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}