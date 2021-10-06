package com.synthesizer.source.empty.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.synthesizer.source.empty.databinding.ItemUserListBinding
import com.synthesizer.source.empty.ui.main.CustomAdapter.CustomViewHolder

class CustomAdapter(private val users: MutableList<User>) :
    RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserListBinding.inflate(inflater)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size


    fun addData(anotherUsers: MutableList<User>) {
        users.addAll(anotherUsers)
        notifyItemRangeChanged(users.size - anotherUsers.size, anotherUsers.size)
    }

    class CustomViewHolder(private val binding: ItemUserListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.apply {
                name.text = user.name
                surname.text = user.surname
            }
        }
    }
}