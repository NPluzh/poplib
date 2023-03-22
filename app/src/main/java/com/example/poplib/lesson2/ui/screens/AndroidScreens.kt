package com.example.poplib.lesson2.ui.screens

import com.example.poplib.lesson2.ui.fragments.users_fragment.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
}
