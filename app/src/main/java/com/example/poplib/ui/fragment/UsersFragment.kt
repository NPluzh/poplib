package com.example.poplib.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poplib.ui.ApiHolder
import com.example.poplib.ui.App
import com.example.poplib.databinding.FragmentUsersBinding
import com.example.poplib.mvp.presenter.UsersPresenter
import com.example.poplib.mvp.view.UsersView
import com.example.poplib.ui.BackButtonListener
import com.example.poplib.mvp.model.repo.retrofit.RetrofitGithubUsersRepo
import com.example.poplib.ui.adapter.UsersRVAdapter
import com.example.poplib.ui.image.GlideImageLoader
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }
    val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(AndroidSchedulers.mainThread(), RetrofitGithubUsersRepo(ApiHolder().api), App.instance.router) }
    var adapter: UsersRVAdapter? = null
    private var vb: FragmentUsersBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            vb = it
        }.root
    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }
    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter( presenter.usersListPresenter, GlideImageLoader())
        vb?.rvUsers?.adapter = adapter
    }
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
    override fun backPressed() = presenter.backPressed()
}
