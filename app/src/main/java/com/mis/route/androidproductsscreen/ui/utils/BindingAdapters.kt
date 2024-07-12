package com.mis.route.androidproductsscreen.ui.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object BindingAdapters {
    @BindingAdapter("url")
    @JvmStatic
    fun bindImage(imageView: ImageView, url: String?) {
        Picasso
            .get()
            .load(url)
            .fit()
            .into(imageView)
    }
}
