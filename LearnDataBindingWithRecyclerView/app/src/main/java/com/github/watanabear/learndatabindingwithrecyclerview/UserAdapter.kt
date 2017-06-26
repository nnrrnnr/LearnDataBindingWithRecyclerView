package com.github.watanabear.learndatabindingwithrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.watanabear.learndatabindingwithrecyclerview.databinding.UserListItemBinding
import com.github.watanabear.learndatabindingwithrecyclerview.domain.User

/**
 * Created by ryo on 2017/06/23.
 */
class UserAdapter(val users: List<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding
        binding.user = users[position]
    }

    class ViewHolder(val binding: UserListItemBinding): RecyclerView.ViewHolder(binding.root)

}