package com.example.poplib.mvp.model.repo.retrofit

import com.example.poplib.mvp.model.api.IDataSource
import com.example.poplib.mvp.model.entity.GithubRepository
import com.example.poplib.mvp.model.entity.GithubUser
import com.example.poplib.mvp.model.repo.IGithubRepositoriesRepo
import com.example.poplib.mvp.model.repo.IGithubUsersRepo
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubRepositoriesRepo(val api: IDataSource): IGithubRepositoriesRepo {
    override fun getRepositories(user: GithubUser) = user.reposUrl?.let { api.getRepositories(user.reposUrl).subscribeOn(Schedulers.io()) }
        ?: Single.error(RuntimeException("User has no repos url"))
}



