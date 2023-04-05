package com.example.poplib.lesson1

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle


class Contract {
    interface MainView :MvpView{

        @AddToEndSingle
        fun setValueButton1(text : String)
        @AddToEndSingle
        fun setValueButton2(text : String)
        @AddToEndSingle
        fun setValueButton3(text : String)
    }

    interface Presenter {

        fun clickButton1()
        fun clickButton2()
        fun clickButton3()

    }
}