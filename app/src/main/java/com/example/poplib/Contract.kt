package com.example.poplib


class Contract {
    interface MainView{

        fun setValueButton1(text : String)
        fun setValueButton2(text : String)
        fun setValueButton3(text : String)
    }

    interface Presenter{

        fun clickButton1()
        fun clickButton2()
        fun clickButton3()

        fun onAttach(mainView: MainView)
    }

}