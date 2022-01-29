package com.example.coursepopularlibraries.ui.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coursepopularlibraries.R
import com.example.coursepopularlibraries.data.model.GitHubUsers
import com.example.coursepopularlibraries.databinding.RecyclerItemListUsersBinding

class ListOfUsersRecyclerViewAdapter(
    private val onClickUser: ((item: GitHubUsers) -> Unit)
) : RecyclerView.Adapter<ListOfUsersRecyclerViewAdapter.MyViewHolder>() {

    private var list = emptyList<GitHubUsers>()

    fun setUsersList(list: List<GitHubUsers>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(
            itemView = inflater.inflate(
                R.layout.recycler_item_list_users, parent, false
            ), onClickUser = onClickUser
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.render(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(
        itemView: View,
        private val onClickUser: (item: GitHubUsers) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemListUsersBinding.bind(itemView)
        fun render(user: GitHubUsers) {
            binding.usersListTextView.text = user.login
            binding.usersListTextView.setOnClickListener { onClickUser(user) }
        }
    }
}