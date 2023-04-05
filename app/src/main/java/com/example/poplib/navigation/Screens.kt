package com.example.poplib.navigation

import com.example.poplib.mvp.model.entity.GithubRepository
import com.example.poplib.mvp.model.entity.GithubUser
import com.example.poplib.ui.fragment.RepositoryFragment
import com.example.poplib.ui.fragment.UserFragment
import com.example.poplib.ui.fragment.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun getUsersScreen() = FragmentScreen { UsersFragment.newInstance() }
    fun getUserScreen(user: GithubUser) = FragmentScreen { UserFragment.newInstance(user)}
    fun getRepositoriesScreen(repository: GithubRepository) = FragmentScreen { RepositoryFragment.newInstance(repository)}
}