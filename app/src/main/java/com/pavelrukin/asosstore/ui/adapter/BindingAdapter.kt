package com.pavelrukin.asosstore.ui.adapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.pavelrukin.asosstore.R
import com.pavelrukin.asosstore.utils.Constants.Companion.IMG_URL
import com.squareup.picasso.Picasso

@BindingAdapter( "imageUrl", "errorImage" )
fun loadImage(view: AppCompatImageView, url: String, errorDrawable: Drawable) {
    if(url.isNotEmpty()) {
        Picasso.get()
            .load(IMG_URL + url)

            .error(errorDrawable)
            .into(view)
    }

}


