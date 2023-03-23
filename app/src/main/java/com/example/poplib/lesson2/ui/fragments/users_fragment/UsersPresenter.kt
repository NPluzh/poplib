package com.example.poplib.lesson2.ui.fragments.users_fragment

import com.example.poplib.lesson2.model.data.GithubUser
import com.example.poplib.lesson2.model.data.GithubUsersRepo
import com.example.poplib.lesson2.ui.recycler_users.IUserListPresenter
import com.example.poplib.lesson2.ui.recycler_users.UserItemView
import com.example.poplib.lesson2.ui.screens.AndroidScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(val usersRepo: GithubUsersRepo, val router: Router) : MvpPresenter<UsersView>() {

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null
        override fun getCount() = users.size
        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()
    val AS = AndroidScreens()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->
            val user = usersListPresenter.users[itemView.pos]
            router.navigateTo(AS.user(user))
        }
    }
    fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }
    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}