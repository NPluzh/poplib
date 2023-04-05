package com.example.poplib.mvp.model.image

interface IImageLoader <T> {// скрываем Glide
    fun loadInto (url: String, container: T)
}