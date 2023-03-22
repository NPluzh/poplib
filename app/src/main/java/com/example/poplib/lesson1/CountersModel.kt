package com.example.poplib.lesson1

class CountersModel {
    private val counters = mutableListOf(0, 0, 0)

    fun getValue(index: Int):Int{
        return counters[index-1]
    }

    fun increaseValue(index: Int){
        counters[index-1]++
    }

}