package com.example.poplib.lesson2.ui.interfaces.recycler// общие для всех списков вещи

//интерфейс для элемента (View?) любого списка в приложении
interface IItemView {// отдельный элемент в который вынесли позицию элемента списка (элемент архитектуры View для списка?)
    var pos: Int
}