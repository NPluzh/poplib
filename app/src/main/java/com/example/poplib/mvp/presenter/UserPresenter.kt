package com.example.poplib.mvp.presenter

import com.example.poplib.mvp.model.entity.GithubUser
import com.example.poplib.mvp.view.UserView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter (val currentUser: GithubUser, val router: Router):  MvpPresenter<UserView>() {

    fun backPressedUserFragment() {
        router.exit()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLogin(currentUser.login)
    }




}