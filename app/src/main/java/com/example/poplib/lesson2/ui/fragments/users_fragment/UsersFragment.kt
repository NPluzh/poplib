package com.example.poplib.lesson2.ui.fragments.users_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poplib.App
import com.example.poplib.databinding.FragmentUsersBinding
import com.example.poplib.lesson2.model.data.GithubUsersRepo
import com.example.poplib.lesson2.ui.fragments.BackButtonListener
import com.example.poplib.lesson2.ui.recycler_users.UsersRVAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }
    val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(GithubUsersRepo(), App.instance.router) }
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
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        vb?.rvUsers?.adapter = adapter
    }
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
    override fun backPressed() = presenter.backPressed()
}
