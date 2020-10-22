package com.pavelrukin.asosstore.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pavelrukin.asosstore.R
import com.pavelrukin.asosstore.databinding.ItemListProductBinding
import com.pavelrukin.asosstore.model.product.Product

class MainAdapter(private val clickListener: (Product) -> Unit) :
    RecyclerView.Adapter<MainAdapter.MovieViewHolder>() {


    private val diffUtilCallBack = object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, diffUtilCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemListProductBinding = DataBindingUtil.inflate(
            inflater,

            R.layout.item_list_product, parent, false
        )

        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val product = differ.currentList[position]
        holder.bind(product)
        holder.binding.tvTitle.isSelected = true
    }


    inner class MovieViewHolder(val binding: ItemListProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {

            binding.product = product
            itemView.setOnClickListener { clickListener(product) }
            binding.executePendingBindings()
        }
    }
}