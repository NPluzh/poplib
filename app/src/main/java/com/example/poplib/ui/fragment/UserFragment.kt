package com.example.poplib.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poplib.ApiHolder
import com.example.poplib.App
import com.example.poplib.databinding.FragmentUserBinding
import com.example.poplib.mvp.model.entity.GithubUser
import com.example.poplib.mvp.model.repo.retrofit.RetrofitGithubRepositoriesRepo
import com.example.poplib.mvp.presenter.UserPresenter
import com.example.poplib.mvp.view.UserView
import com.example.poplib.ui.adapter.ReposotoriesRVAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment(user: GithubUser) : MvpAppCompatFragment(), UserView {
    companion object {
        fun newInstance(user: GithubUser) = UserFragment(user)
    }

    val presenter: UserPresenter by moxyPresenter {

        UserPresenter(
            user, App.instance.router,
            AndroidSchedulers.mainThread(),
            RetrofitGithubRepositoriesRepo(ApiHolder().api)
        )
    }

    private var vb: FragmentUserBinding? = null
    var adapter: ReposotoriesRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUserBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }


/*
    override fun showLogin(login: String) {
        vb?.userLoginTextview?.text = login
    }*/

    override fun init() {

        vb?.rvRepositories?.layoutManager = LinearLayoutManager(context)
        adapter = ReposotoriesRVAdapter(presenter.repositoriesListPresenter)
        vb?.rvRepositories?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun release() {

    }
}