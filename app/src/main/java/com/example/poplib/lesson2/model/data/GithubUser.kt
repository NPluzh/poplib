package com.example.poplib.lesson2.model.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser( // сущность, представляющая пользователя
    val login: String
) : Parcelable
