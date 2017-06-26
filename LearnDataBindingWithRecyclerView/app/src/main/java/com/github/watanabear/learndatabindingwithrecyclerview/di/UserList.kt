package com.github.watanabear.learndatabindingwithrecyclerview.di

import com.github.watanabear.learndatabindingwithrecyclerview.UserListActivity
import dagger.Module
import dagger.Subcomponent

/**
 * Created by ryo on 2017/06/23.
 */
@Module
class UserListModule

@Subcomponent(modules = arrayOf(UserListModule::class))
interface UserListComponent {
    fun inject(a: UserListActivity)
}