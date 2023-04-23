package com.example.poplib.ui.image

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.poplib.R
import com.example.poplib.mvp.model.image.IImageLoader

class GlideImageLoader : IImageLoader<ImageView> {
    override fun loadInto(url: String, container: ImageView) {
        Glide.with(container.context)
            .load(url)
            .placeholder(R.drawable.ic_man)
            .into(container)
    }
}