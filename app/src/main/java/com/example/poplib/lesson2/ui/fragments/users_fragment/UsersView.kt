package com.example.poplib.lesson2.ui.fragments.users_fragment

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView: MvpView {
    fun init ()
    fun updateList()
}