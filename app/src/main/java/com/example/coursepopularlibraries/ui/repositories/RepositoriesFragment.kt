package com.example.coursepopularlibraries.ui.repositories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.coursepopularlibraries.databinding.ListOfUsersFragmentBinding
import com.example.coursepopularlibraries.databinding.RepositoriesFragmentBinding
import com.example.coursepopularlibraries.ui.users.ListOfUsersFragment
import com.example.coursepopularlibraries.ui.users.ListOfUsersViewModel

class RepositoriesFragment : Fragment() {

    companion object {
        fun newInstance() = ListOfUsersFragment()
    }

    private lateinit var binding: RepositoriesFragmentBinding
    private val viewModel by viewModels<ListOfUsersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RepositoriesFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}