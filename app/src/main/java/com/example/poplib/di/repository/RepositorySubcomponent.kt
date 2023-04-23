package com.example.poplib.di.repository

import com.example.poplib.di.repository.module.RepositoryModule
import com.example.poplib.mvp.presenter.RepositoryPresenter
import com.example.poplib.mvp.presenter.UserPresenter
import dagger.Subcomponent

@RepositoryScope
@Subcomponent(
    modules = [
        RepositoryModule::class
    ]
)
interface RepositorySubcomponent {
    fun inject(userPresenter: UserPresenter)
    fun inject(repositoryPresenter: RepositoryPresenter)
}