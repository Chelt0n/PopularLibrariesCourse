package com.example.coursepopularlibraries.ui.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coursepopularlibraries.R
import com.example.coursepopularlibraries.data.model.GitHubUsers
import com.example.coursepopularlibraries.databinding.RecyclerItemListUsersBinding

class ListOfUsersRecyclerViewAdapter() :
    RecyclerView.Adapter<ListOfUsersRecyclerViewAdapter.MyViewHolder>() {

    private var list = emptyList<GitHubUsers>()

    fun setUserList(list: List<GitHubUsers>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item_list_users, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.render(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerItemListUsersBinding.bind(itemView)
        fun render(list: GitHubUsers) {
            binding.usersListTextView.text = list.login
        }
    }
}