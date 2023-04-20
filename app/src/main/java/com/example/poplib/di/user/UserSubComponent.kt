package com.example.poplib.di.user

import com.example.poplib.di.user.module.UserModule
import com.example.poplib.mvp.presenter.UsersPresenter
import com.example.poplib.ui.adapter.UsersRVAdapter
import dagger.Subcomponent

@UserScope
@Subcomponent(
    modules = [
        UserModule::class
    ]
)
interface UserSubcomponent {
    fun repositorySubcomponent(): RepositorySubcomponent

    fun inject(usersPresenter: UsersPresenter)
    fun inject(usersRVAdapter: UsersRVAdapter)
}