package com.example.poplib


class PresenterImpl:Contract.Presenter {
    private val counter = CountersModel()
    private var mainView: Contract.MainView? = null


    override fun clickButton1() {
        counter.increaseValue(1)
        mainView?.setValueButton1(counter.getValue(1).toString())

    }

    override fun clickButton2() {
        counter.increaseValue(2)
        mainView?.setValueButton2(counter.getValue(2).toString())
    }

    override fun clickButton3() {
        counter.increaseValue(3)
        mainView?.setValueButton3(counter.getValue(3).toString())
    }

    override fun onAttach(mView: Contract.MainView) {
        mainView = mView
    }
}