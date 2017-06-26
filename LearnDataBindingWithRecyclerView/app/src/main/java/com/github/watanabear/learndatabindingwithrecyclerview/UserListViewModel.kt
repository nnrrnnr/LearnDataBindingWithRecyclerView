package com.github.watanabear.learndatabindingwithrecyclerview

import android.databinding.BaseObservable
import com.github.watanabear.learndatabindingwithrecyclerview.domain.User

/**
 * Created by ryo on 2017/06/23.
 */
class UserListViewModel: BaseObservable() {

    val users = listOf(
            User("taro", "https://avatars0.githubusercontent.com/u/15207701?v=3&s=460"),
            User("taro", "https://avatars0.githubusercontent.com/u/15207701?v=3&s=460"),
            User("taro", "https://avatars0.githubusercontent.com/u/15207701?v=3&s=460")
    )


}