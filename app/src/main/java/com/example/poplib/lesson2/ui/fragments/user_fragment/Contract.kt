package com.example.poplib.lesson2.ui.fragments.user_fragment



import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

class Contract {

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface UserFragmentView : MvpView{
        fun showLogin(login : String)
    }


    interface UserFragmentPresenter {

        fun backPressedUserFragment()

    }
}