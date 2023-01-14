package com.tzuhsien.taipeizoo.ext

import android.widget.ImageView
import com.tzuhsien.taipeizoo.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(uri: String?) {
    Glide.with(this)
        .load(uri)
        .apply(
            RequestOptions
                .placeholderOf(R.drawable.ic_menu)
                .error(R.drawable.ic_menu)
        )
        .into(this)
}