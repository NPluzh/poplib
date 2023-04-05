package com.example.poplib.mvp.presenter

import com.example.poplib.mvp.model.entity.GithubRepository
import com.example.poplib.mvp.model.entity.GithubUser
import com.example.poplib.mvp.model.repo.IGithubRepositoriesRepo
import com.example.poplib.mvp.presenter.list.IRepositoryListPresenter
import com.example.poplib.mvp.view.RepositoryItemView
import com.example.poplib.mvp.view.UserView
import com.example.poplib.navigation.Screens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter

class UserPresenter (val currentUser: GithubUser, val router: Router, val mainThreadScheduler: Scheduler, val repositoriesRepo: IGithubRepositoriesRepo):  MvpPresenter<UserView>() {

    class RepositoriesListPresenter : IRepositoryListPresenter {
        val repositories = mutableListOf<GithubRepository>()
        override var itemClickListener: ((RepositoryItemView) -> Unit)? = null
        override fun getCount() = repositories.size

        override fun bindView(view: RepositoryItemView) {
            val repository = repositories[view.pos]
            repository.name?.let { view.setName(it) }
        }
    }

    val repositoriesListPresenter = RepositoriesListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        repositoriesListPresenter.itemClickListener = { itemView ->
            val repository = repositoriesListPresenter.repositories[itemView.pos]
            router.navigateTo(Screens.getRepositoriesScreen(repository))
        }

    }

    fun loadData() {

        repositoriesRepo.getRepositories(currentUser)
            .observeOn(mainThreadScheduler)
            .subscribe({ repositories ->
                repositoriesListPresenter.repositories.clear()
                repositoriesListPresenter.repositories.addAll(repositories)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        viewState.release()
    }
}
