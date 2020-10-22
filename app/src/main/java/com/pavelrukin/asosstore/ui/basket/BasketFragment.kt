package com.pavelrukin.asosstore.ui.basket

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pavelrukin.asosstore.R
import com.pavelrukin.asosstore.databinding.BasketFragmentBinding
import com.pavelrukin.asosstore.databinding.ItemBasketBinding
import com.pavelrukin.asosstore.model.detail_product.DetailResponse
import com.pavelrukin.asosstore.ui.detail.DetailViewModel
import com.pavelrukin.asosstore.utils.extensions.disableItemAnimator
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.roundToInt


class BasketFragment : Fragment() {
    private lateinit var binding: BasketFragmentBinding
    private lateinit var bindingItem:ItemBasketBinding
    private val viewModel: DetailViewModel by viewModel()
    lateinit var basketAdapter: BasketAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.basket_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        //binding.rvBasket.  itemAnimator?.changeDuration = 0

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //     binding.rvBasket.itemAnimator?.changeDuration = 0

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initList()
        initRecyclerView()

    }


    private fun initList() {
        viewModel.getSavedProduct().observe(viewLifecycleOwner, Observer { result ->

            basketAdapter.differ.submitList(result)
            binding.totalAmount = result.map { it.priceCounting }.sumByDouble { it!!}.toString()

            basketAdapter.notifyDataSetChanged()
        })
    }

    private fun initRecyclerView() {
        basketAdapter = BasketAdapter(::deleteBasketItem, ::basketPlusProduct, ::basketMinusProduct)
        binding.rvBasket.apply {
            adapter = basketAdapter
            layoutManager = LinearLayoutManager(activity)
            disableItemAnimator()
        }

    }

    private fun basketMinusProduct(detailResponse: DetailResponse) {
        viewModel.btnMinus(detailResponse)
        Log.d("BasketFragment", "MINUS: onclick")
    }

    private fun basketPlusProduct(detailResponse: DetailResponse) {
        viewModel.btnPlus(detailResponse)
        Log.d("BasketFragment", "PLUS: onclick")
    }

    private fun deleteBasketItem(product: DetailResponse) {
        viewModel.deleteProduct(product)
    }


}




