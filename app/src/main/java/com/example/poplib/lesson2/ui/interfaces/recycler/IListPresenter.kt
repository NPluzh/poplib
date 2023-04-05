package com.example.poplib.lesson2.ui.interfaces.recycler// общие для всех списков вещи

interface IListPresenter <V : IItemView> { // интерфейс Presenter на случай если будут еще списки
    var itemClickListener: ((V) -> Unit)? // функция, принимающая на вход View (таким образом по пришедшей на вход View мы получаем от неё позицию и требуемый элемент)
    fun bindView(view: V)// передача View
    fun getCount(): Int// функция получения количества элементов
}

