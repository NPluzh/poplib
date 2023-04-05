package com.example.poplib.lesson2.ui.fragments.user_fragment

import com.example.poplib.lesson2.model.data.GithubUser
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter (val currentUser: GithubUser, val router: Router): Contract.UserFragmentPresenter, MvpPresenter<Contract.UserFragmentView>() {

    override fun backPressedUserFragment() {
        router.exit()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLogin(currentUser.login)
    }




}