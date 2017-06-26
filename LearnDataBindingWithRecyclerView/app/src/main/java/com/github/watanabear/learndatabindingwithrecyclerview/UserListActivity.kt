package com.github.watanabear.learndatabindingwithrecyclerview

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.github.watanabear.learndatabindingwithrecyclerview.databinding.UserListActivityBinding

class UserListActivity : AppCompatActivity() {

    lateinit var binding: UserListActivityBinding
    lateinit var viewModel: UserListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<UserListActivityBinding>(this, R.layout.user_list_activity)
        viewModel = UserListViewModel()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = UserAdapter(viewModel.users)
    }
}
