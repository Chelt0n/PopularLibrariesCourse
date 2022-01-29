package com.example.coursepopularlibraries.ui.repositories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coursepopularlibraries.R
import com.example.coursepopularlibraries.data.model.User
import com.example.coursepopularlibraries.databinding.RecyclerViewCardItemsBinding

class UserRepositoriesRecyclerViewAdapter(
    private val onClickUser: ((item: User) -> Unit)
) : RecyclerView.Adapter<UserRepositoriesRecyclerViewAdapter.MyViewHolder>() {

    private var list = emptyList<User>()

    fun setUsersList(list: List<User>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(
            itemView = inflater.inflate(
                R.layout.recycler_view_card_items, parent, false
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
        private val onClickUser: (item: User) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val binding = RecyclerViewCardItemsBinding.bind(itemView)
        fun render(user: User) {
            binding.userRepositoryName.text = user.name
        }
    }
}