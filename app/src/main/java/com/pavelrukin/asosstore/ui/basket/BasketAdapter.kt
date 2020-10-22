package com.pavelrukin.asosstore.ui.basket


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pavelrukin.asosstore.R
import com.pavelrukin.asosstore.databinding.ItemBasketBinding
import com.pavelrukin.asosstore.model.detail_product.DetailResponse
import com.pavelrukin.asosstore.utils.Constants
import com.pavelrukin.asosstore.utils.extensions.imgHelper
import com.squareup.picasso.Picasso


class BasketAdapter(
    val itemDeleteListener: (product: DetailResponse) -> Unit,
    val btnPlusProduct: (product: DetailResponse) -> Unit,
    val btnMinusProduct: (product: DetailResponse) -> Unit
) :
    RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {

    private val diffUtilCallBack = object : DiffUtil.ItemCallback<DetailResponse>() {
        override fun areItemsTheSame(oldItem: DetailResponse, newItem: DetailResponse): Boolean {
            return oldItem.productCount == newItem.productCount && oldItem.id == newItem.id &&
                    oldItem.priceDetail == newItem.priceDetail
        }
        override fun areContentsTheSame(oldItem: DetailResponse, newItem: DetailResponse): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, diffUtilCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemBasketBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.item_basket, parent, false
        )
        return BasketViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        val product = differ.currentList[position]
        holder.bind(product)
    }

    inner class BasketViewHolder(var binding: ItemBasketBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: DetailResponse) {
            binding.product = product
            binding.tvTitleBasket.isSelected = true
            Picasso.get().load(Constants.IMG_URL + product.media?.images?.map { it.url }.toString()
                    .imgHelper()
            ).into(binding.basket)

            //TextView
            binding.count = product.productCount.toString()
            binding.price = product.priceCounting.toString()
            //buttons
            binding.fabDeleteProduct.setOnClickListener { itemDeleteListener(product) }
            binding.btnPlus.setOnClickListener { btnPlusProduct(product) }  //    notifyItemRangeChanged(adapterPosition,product.productCount)
            binding.btnMinus.setOnClickListener { btnMinusProduct(product) } //       notifyItemRangeChanged(adapterPosition,product.productCount)

            binding.executePendingBindings()


        }

    }


}

