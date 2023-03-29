package com.example.poplib.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.poplib.App
import com.example.poplib.databinding.FragmentUserBinding
import com.example.poplib.mvp.model.entity.GithubUser
import com.example.poplib.mvp.view.UserView
import com.example.poplib.mvp.presenter.UserPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment (user: GithubUser): MvpAppCompatFragment(), UserView{
    companion object {
        fun newInstance(user: GithubUser) = UserFragment(user)
    }
    val presenter: UserPresenter by moxyPresenter { UserPresenter(user, App.instance.router) }

    private var vb: FragmentUserBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) =
        FragmentUserBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun showLogin(login: String) {
        vb?.userLoginTextview?.text = login
    }
}