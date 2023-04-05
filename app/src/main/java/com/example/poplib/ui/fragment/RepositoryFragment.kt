package com.example.poplib.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poplib.App
import com.example.poplib.R
import com.example.poplib.databinding.FragmentRepositoryBinding
import com.example.poplib.databinding.FragmentUserBinding
import com.example.poplib.mvp.model.entity.GithubRepository
import com.example.poplib.mvp.presenter.RepositoryPresenter
import com.example.poplib.mvp.view.RepositoryView
import com.example.poplib.ui.adapter.ReposotoriesRVAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RepositoryFragment : MvpAppCompatFragment(), RepositoryView {

    companion object {
        private const val REPOSITORY_ARG = "repository"

        fun newInstance(repository: GithubRepository) = RepositoryFragment().apply {
            arguments = Bundle().apply {
                putParcelable(REPOSITORY_ARG, repository)
            }
        }
    }


    var adapter: ReposotoriesRVAdapter? = null
    private var vb: FragmentRepositoryBinding? = null

    val presenter: RepositoryPresenter by moxyPresenter {
        val repository = arguments?.getParcelable<GithubRepository>(REPOSITORY_ARG) as GithubRepository
        RepositoryPresenter(repository, App.instance.router)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentRepositoryBinding.inflate(inflater, container, false).also {
            vb = it
        }.root
        //View.inflate(context, R.layout.fragment_repository, null)

    override fun init() {
    }

    override fun setId(text: String) {
        vb?.tvId?.text = text
    }

    override fun setTitle(text: String) {
        vb?.tvTitle?.text = text
    }

    override fun setForksCount(text: String) {
        vb?.tvForksCount?.text = text
    }
}