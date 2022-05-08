package com.tardigrada.pojistiseapp.fragments.update

import android.app.AlertDialog
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
import com.tardigrada.pojistiseapp.entities.User
import com.tardigrada.pojistiseapp.entities.viewModels.UserViewModel

class UserUpdateFragment : Fragment() {

    private val args by navArgs<UserUpdateFragmentArgs>()

    private lateinit var mUserViewModel: UserViewModel

    private lateinit var etUserUpdateFirstName: EditText
    private lateinit var etUserUpdateLastName: EditText
    private lateinit var etUserUpdateEmail: EditText
    private lateinit var btnUpdateUser: Button
    private lateinit var btnDeleteUser: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        etUserUpdateFirstName = view.findViewById(R.id.etUserUpdateFirstName)
        etUserUpdateLastName = view.findViewById(R.id.etUserUpdateLastName)
        etUserUpdateEmail = view.findViewById(R.id.etUserUpdateEmail)
        btnUpdateUser = view.findViewById(R.id.btnUpdateUser)
        btnDeleteUser = view.findViewById(R.id.btnDeleteUser)

        etUserUpdateFirstName.setText(args.currentUser.firstName)
        etUserUpdateLastName.setText(args.currentUser.lastName)
        etUserUpdateEmail.setText(args.currentUser.email)

        btnUpdateUser.setOnClickListener {
            updateItem()
        }

        btnDeleteUser.setOnClickListener {
            deleteUser()
        }

        return view
    }

    private fun updateItem() {
        val firstName = etUserUpdateFirstName.text.toString()
        val lastName = etUserUpdateLastName.text.toString()
        val email = etUserUpdateEmail.text.toString()

        if (inputCheck(firstName, lastName, email)) {
            // create user object
            val updatedUser = User(args.currentUser.userId, firstName, lastName, email)
            // update current user
            mUserViewModel.updateUser(updatedUser)
            Toast.makeText(requireContext(), "Klient byl aktualizován.", Toast.LENGTH_SHORT).show()
            // navigate to the list of users
            findNavController().navigate(R.id.action_userUpdateFragment_to_usersListFragment)
        } else {
            Toast.makeText(requireContext(), "Prosím, vyplňte všechny údaje.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, email: String): Boolean {
        return !(TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(email))
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Ano") { _, _ ->
            mUserViewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(), "Uživatel ${args.currentUser.firstName} ${args.currentUser.lastName} byl vymazán.", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_userUpdateFragment_to_usersListFragment)
        }
        builder.setNegativeButton("Ne") { _, _ -> }
        builder.setTitle("Vymazat klienta ${args.currentUser.firstName} ${args.currentUser.lastName}?")
        builder.setMessage("Jste si jistý, že chcete klienta ${args.currentUser.firstName} ${args.currentUser.lastName} vymazat?")
        builder.create().show()
    }
}