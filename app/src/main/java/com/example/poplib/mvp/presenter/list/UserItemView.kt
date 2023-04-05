package com.example.poplib.mvp.presenter.list


interface UserItemView : IItemView {
    //View для recycler пользователей
    // интерфейс для ViewHolder ( в адаптере в роли View выступает ViewHolder)
    fun setLogin(text: String)
    fun loadAvatar(url: String)
}