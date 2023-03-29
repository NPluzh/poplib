package com.example.poplib.mvp.model.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser( // сущность, представляющая пользователя
    val login: String
) : Parcelable
