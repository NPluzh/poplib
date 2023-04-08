package com.example.poplib.mvp.presenter

import com.example.poplib.mvp.view.MainView
import com.example.poplib.navigation.Screens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(val router: Router) : MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.getUsersScreen())
    }
    fun backClicked() {
        router.exit()
    }
}

