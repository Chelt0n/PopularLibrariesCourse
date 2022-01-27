package com.example.coursepopularlibraries.ui.users

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.coursepopularlibraries.data.model.GitHubUsers
import com.example.coursepopularlibraries.databinding.FragmentListOfUsersBinding

class ListOfUsersFragment : Fragment() {

    private var _binding: FragmentListOfUsersBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel by viewModels<ListOfUsersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListOfUsersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getGitHubUsers().observe(viewLifecycleOwner, { appState -> render(appState) })
    }

    private fun render(appState: AppStateGitHubUsers) {
        when (appState) {
            is AppStateGitHubUsers.Loading -> Log.d("myLog", "Loading")
            is AppStateGitHubUsers.Success -> logD(appState.serverResponseData)
            is AppStateGitHubUsers.Error -> Log.d("myLog", "Error")
        }
    }

}