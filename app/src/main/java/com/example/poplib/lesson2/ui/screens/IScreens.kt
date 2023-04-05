package com.example.poplib.lesson2.ui.screens

import com.example.poplib.lesson2.model.data.GithubUser
import com.example.poplib.lesson2.ui.fragments.user_fragment.Contract
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun user(usser: GithubUser):Screen
}
