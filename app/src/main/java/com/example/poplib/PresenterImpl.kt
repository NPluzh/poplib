package com.example.poplib


class PresenterImpl:Contract.Presenter {
    private val counter = CountersModel()
    private var mainView: Contract.MainView? = null


    override fun clickButton1() {
        counter.increaseValue(INDEX_COUNTER_1)
        mainView?.setValueButton1(counter.getValue(INDEX_COUNTER_1).toString())

    }

    override fun clickButton2() {
        counter.increaseValue(INDEX_COUNTER_2)
        mainView?.setValueButton2(counter.getValue(INDEX_COUNTER_2).toString())
    }

    override fun clickButton3() {
        counter.increaseValue(INDEX_COUNTER_3)
        mainView?.setValueButton3(counter.getValue(INDEX_COUNTER_3).toString())
    }

    override fun onAttach(mView: Contract.MainView) {
        mainView = mView
    }

    companion object{
        const val INDEX_COUNTER_1 = 1
        const val INDEX_COUNTER_2 = 2
        const val INDEX_COUNTER_3 = 3
    }
}