package com.pavelrukin.asosstore.ui.detail

import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pavelrukin.asosstore.R
import com.pavelrukin.asosstore.model.detail_product.DetailResponse
import com.pavelrukin.asosstore.model.detail_product.Image
import com.pavelrukin.asosstore.model.detail_product.Media
import com.pavelrukin.asosstore.utils.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_detail_product.view.*

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    private val diffUtilCallBack = object : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, diffUtilCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {

        return DetailViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_detail_product, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val img = differ.currentList[position]
        holder.itemView.apply {
            Picasso.get().load(Constants.IMG_URL + img.url).into(iv_detail_product)

        }
    }


    inner class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}