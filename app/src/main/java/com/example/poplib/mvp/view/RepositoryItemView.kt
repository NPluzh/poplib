package com.example.poplib.mvp.view

import com.example.poplib.mvp.presenter.list.IItemView

interface RepositoryItemView: IItemView {
    fun setName(text: String)
}