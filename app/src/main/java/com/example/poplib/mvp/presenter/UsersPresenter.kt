package com.example.poplib.mvp.presenter

import com.example.poplib.mvp.model.entity.GithubUser
import com.example.poplib.mvp.model.repo.IGithubUsersRepo
import com.example.poplib.mvp.view.UsersView
import com.example.poplib.mvp.presenter.list.IUserListPresenter
import com.example.poplib.mvp.presenter.list.UserItemView
import com.example.poplib.navigation.Screens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter

class UsersPresenter(val mainThreadScheduler: Scheduler, val usersRepo: IGithubUsersRepo, val router: Router) : MvpPresenter<UsersView>() {

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null
        override fun getCount() = users.size
        override fun bindView(view: UserItemView) {
            val user = users[view.pos]

            user.login?.let{
                view.setLogin(it)
            }
            user.avatarUrl?.let{
                view.loadAvatar(it)
            }

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
        usersRepo.getUsers().observeOn(mainThreadScheduler).subscribe{ users ->
            usersListPresenter.users.clear()
            usersListPresenter.users.addAll(users)
            viewState.updateList()
        }

    }
    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}