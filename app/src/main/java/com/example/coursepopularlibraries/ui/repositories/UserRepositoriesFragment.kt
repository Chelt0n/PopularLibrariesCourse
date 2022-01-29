package com.example.coursepopularlibraries.ui.repositories

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import coil.load
import com.example.coursepopularlibraries.data.model.GitHubUsers
import com.example.coursepopularlibraries.databinding.FragmentRepositoriesBinding

class UserRepositoriesFragment : Fragment() {

    companion object {
        private const val KEY = "key"
        fun newInstance(user: GitHubUsers) = UserRepositoriesFragment().apply {
            val bundle = Bundle()
            bundle.putSerializable(KEY, user)
            arguments = bundle
        }
    }


    private var _binding: FragmentRepositoriesBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel by viewModels<RepositoriesViewModel>()
    private val adapter by lazy {
        UserRepositoriesRecyclerViewAdapter(
            onClickUser = {
                Toast.makeText(context, "NTS", Toast.LENGTH_SHORT).show()
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepositoriesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gitHubUser = requireArguments().getSerializable(KEY) as GitHubUsers


        binding.profileImage.load(gitHubUser.avatarURL)
        binding.login.text = gitHubUser.login

        binding.recyclerViewRepositories.adapter = adapter
        viewModel.getUserRepositories(gitHubUser.login)
            .observe(viewLifecycleOwner, { appState -> render(appState) })

    }

    private fun render(appState: AppStateUser) {
        when (appState) {
            is AppStateUser.Loading -> Log.d("mylog", "Loading1")
            is AppStateUser.Success -> {
                adapter.setUsersList(appState.serverResponseData)
            }
            is AppStateUser.Error -> Log.d("mylog", "Error1")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}