package com.tardigrada.pojistiseapp.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tardigrada.pojistiseapp.R

class UsersListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_users_list, container, false)

        val floatBtnAddUser = view.findViewById<FloatingActionButton>(R.id.floatBtnAddUser)
        floatBtnAddUser.setOnClickListener {
            findNavController().navigate(R.id.action_usersListFragment_to_userAddFragment)
        }

        return view
    }
}