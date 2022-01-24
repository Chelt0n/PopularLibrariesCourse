package com.example.coursepopularlibraries.ui.users

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.coursepopularlibraries.R
import com.example.coursepopularlibraries.databinding.ListOfUsersFragmentBinding

class ListOfUsersFragment : Fragment() {

    companion object {
        fun newInstance() = ListOfUsersFragment()
    }

    private lateinit var binding: ListOfUsersFragmentBinding
    private val viewModel by viewModels<ListOfUsersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListOfUsersFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}