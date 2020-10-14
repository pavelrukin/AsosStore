package com.pavelrukin.asosstore.ui.adapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.pavelrukin.asosstore.R
import com.squareup.picasso.Picasso

@BindingAdapter( "app:imageUrl", "app:errorImage" )
fun loadImage(view: AppCompatImageView?, url: String?, errorDrawable: Drawable) {
    Picasso.get()
        .load("https://$url")
        .placeholder(R.drawable.ic_image_not_supported)
        .error(errorDrawable)
        .into(view)
}

