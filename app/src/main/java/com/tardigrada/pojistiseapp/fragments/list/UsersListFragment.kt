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
import com.tardigrada.pojistiseapp.entities.viewModels.UserViewModel

class UsersListFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_users_list, container, false)

        // variables
        val rvUsersList = view.findViewById<RecyclerView>(R.id.rvUsersList)

        // recyclerView
        val adapter = UserListAdapter()
        rvUsersList.adapter = adapter
        rvUsersList.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData().observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })

        val floatBtnAddUser = view.findViewById<FloatingActionButton>(R.id.floatBtnAddUser)
        floatBtnAddUser.setOnClickListener {
            findNavController().navigate(R.id.action_usersListFragment_to_userAddFragment)
        }

        return view
    }
}