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
import com.tardigrada.pojistiseapp.entities.User
import com.tardigrada.pojistiseapp.entities.viewModels.UserViewModel
import kotlinx.coroutines.launch

class UserAddFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_user_add, container, false)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        // variables
        val btnAddUser = view.findViewById<Button>(R.id.btnAddUser)

        btnAddUser.setOnClickListener {
            insertUserDataToDatabase()
        }
        return view
    }

private fun insertUserDataToDatabase() {
    // variables
    val etUserFirstName = view?.findViewById<EditText>(R.id.etUserFirstName)
    val etUserLastName = view?.findViewById<EditText>(R.id.etUserLastName)
    val etUserEmail = view?.findViewById<EditText>(R.id.etUserEmail)

    val firstName = etUserFirstName?.text.toString()
    val lastName = etUserLastName?.text.toString()
    val email = etUserEmail?.text.toString()


    if (inputCheck(firstName, lastName, email)) {
        // Create user object
        val user = User(0, firstName, lastName, email)
        // Add data to the database
        saveUser(user)
        Toast.makeText(requireContext(), "Klient byl uložen do databáze.", Toast.LENGTH_LONG).show()
        // Navigate back to the list
        findNavController().navigate(R.id.action_userAddFragment_to_usersListFragment)
    } else {
        Toast.makeText(requireContext(), "Prosím, vyplňte všechny údaje.", Toast.LENGTH_LONG).show()
    }
}

private fun inputCheck(firstName: String, lastName: String, email: String): Boolean {
    return !(TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(email))
}

private fun saveUser(user: User) {
    lifecycleScope.launch {
        userViewModel.addUser(user)
    }
}
}