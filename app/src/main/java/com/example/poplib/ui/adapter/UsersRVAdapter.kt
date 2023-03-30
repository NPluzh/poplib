package com.example.poplib.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.poplib.databinding.ItemUserBinding
import com.example.poplib.mvp.presenter.list.IUserListPresenter
import com.example.poplib.mvp.presenter.list.UserItemView

class UsersRVAdapter(val presenter: IUserListPresenter) : RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {// Presenter передается, чтобы на view не замыкалась логика

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        ).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)// invoke используется из-за синтаксических ограничений
            }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(val vb: ItemUserBinding) : RecyclerView.ViewHolder(vb.root),
        UserItemView {
        override var pos = -1
        override fun setLogin(text: String) = with(vb) {
            loginTextview.text = text
        }

        override fun loadAvatar(url: String) {
            //TODO("Not yet implemented")
        }
    }
}