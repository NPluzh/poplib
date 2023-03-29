package com.example.poplib.mvp.presenter

import com.example.poplib.mvp.model.entity.GithubUser
import com.example.poplib.mvp.model.entity.GithubUsersRepo
import com.example.poplib.mvp.view.UsersView
import com.example.poplib.mvp.presenter.list.IUserListPresenter
import com.example.poplib.mvp.presenter.list.UserItemView
import com.example.poplib.navigation.Screens
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

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->
            val user = usersListPresenter.users[itemView.pos]
            router.navigateTo(Screens.getUserScreen(user))
        }
    }
    fun loadData() {
        val users = usersRepo.getUsers()
            .filter{it != null}
            .subscribe{
                usersListPresenter.users.add(it)
                viewState.updateList()
            }

    }
    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}