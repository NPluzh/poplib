package com.example.poplib.mvp.model.repo.retrofit

import com.example.poplib.mvp.model.api.IDataSource
import com.example.poplib.mvp.model.repo.IGithubUsersRepo
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUsersRepo(val api: IDataSource) : IGithubUsersRepo {
    override fun getUsers() = api.getUsers().subscribeOn(Schedulers.io())
}
