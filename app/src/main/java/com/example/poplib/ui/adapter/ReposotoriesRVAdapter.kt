package com.example.poplib.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.poplib.R
import com.example.poplib.databinding.ItemRepositoryBinding
import com.example.poplib.mvp.presenter.list.IRepositoryListPresenter
import com.example.poplib.mvp.view.RepositoryItemView
import kotlinx.android.extensions.LayoutContainer

class ReposotoriesRVAdapter(val presenter: IRepositoryListPresenter) :
    RecyclerView.Adapter<ReposotoriesRVAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        )

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }

    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer, RepositoryItemView {
        override var pos = -1
        override fun setName(text: String) = with(containerView) {
            val tmp = findViewById<TextView>(R.id.name_textview)
            tmp.text = text
            // name_textview.text = text
            // }
        }
    }
}