package com.example.poplib.lesson1


import moxy.MvpPresenter


class PresenterImpl: Contract.Presenter, MvpPresenter<Contract.MainView>() {
    private val counter = CountersModel()

    override fun clickButton1() {
        counter.increaseValue(INDEX_COUNTER_1)
        viewState.setValueButton1(counter.getValue(INDEX_COUNTER_1).toString())

    }

    override fun clickButton2() {
        counter.increaseValue(INDEX_COUNTER_2)
        viewState?.setValueButton2(counter.getValue(INDEX_COUNTER_2).toString())
    }

    override fun clickButton3() {
        counter.increaseValue(INDEX_COUNTER_3)
        viewState?.setValueButton3(counter.getValue(INDEX_COUNTER_3).toString())
    }

    companion object{
        const val INDEX_COUNTER_1 = 1
        const val INDEX_COUNTER_2 = 2
        const val INDEX_COUNTER_3 = 3
    }
}