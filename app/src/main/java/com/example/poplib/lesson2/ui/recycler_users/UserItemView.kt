package com.example.poplib.lesson2.ui.recycler_users

import com.example.poplib.lesson2.ui.interfaces.recycler.IItemView


interface UserItemView : IItemView {//View для recycler пользователей
    // интерфейс для ViewHolder ( в адаптере в роли View выступает ViewHolder)
    fun setLogin (text: String)
}