package com.example.coursepopularlibraries.ui.users

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coursepopularlibraries.App
import com.example.coursepopularlibraries.R
import com.example.coursepopularlibraries.databinding.FragmentListOfUsersBinding
import com.example.coursepopularlibraries.ui.repositories.UserRepositoriesFragment
import com.example.coursepopularlibraries.utils.viewModels

class ListOfUsersFragment : Fragment() {

    private var _binding: FragmentListOfUsersBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel by viewModels(this) {
        ListOfUsersViewModel((requireActivity().application as App).repository)
    }
    private val adapter by lazy {
        ListOfUsersRecyclerViewAdapter(
            onClickUser = {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container, UserRepositoriesFragment.newInstance(it))
                    .addToBackStack("").commit()
            }
        )
    }

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
        binding.recyclerView.adapter = adapter


    }


    private fun render(appState: AppStateGitHubUsers) {
        when (appState) {
            is AppStateGitHubUsers.Loading -> Log.d("myLog", "Loading")
            is AppStateGitHubUsers.Success -> {
                adapter.setUsersList(appState.serverResponseData)
            }
            is AppStateGitHubUsers.Error -> Log.d("myLog", "Error")
        }
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
