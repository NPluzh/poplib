package com.example.poplib.lesson2.ui.screens

import com.example.poplib.lesson2.model.data.GithubUser
import com.example.poplib.lesson2.ui.fragments.user_fragment.UserFragment
import com.example.poplib.lesson2.ui.fragments.users_fragment.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(usser:GithubUser) = FragmentScreen { UserFragment.newInstance(usser) }
}
