package com.example.poplib.mvp.presenter.list// общие для всех списков вещи

//интерфейс для элемента (View?) любого списка в приложении
interface IItemView {// отдельный элемент в который вынесли позицию элемента списка (элемент архитектуры View для списка?)
    var pos: Int
}