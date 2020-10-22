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
import com.google.android.material.snackbar.Snackbar
import com.pavelrukin.asosstore.R
import com.pavelrukin.asosstore.databinding.BasketFragmentBinding
import com.pavelrukin.asosstore.model.detail_product.DetailResponse
import com.pavelrukin.asosstore.utils.extensions.disableItemAnimator
import org.koin.androidx.viewmodel.ext.android.viewModel


class BasketFragment : Fragment() {
    private lateinit var binding: BasketFragmentBinding
    private val viewModel: BasketViewModel by viewModel()
    lateinit var basketAdapter: BasketAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.basket_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initList()
        initRecyclerView()
    }

    private fun initList() {
        viewModel.getSavedProduct().observe(viewLifecycleOwner, Observer { result ->
            basketAdapter.differ.submitList(result)
            binding.totalAmount =
                "$" + result.map { it.priceCounting }.sumByDouble { it!! }.toString()
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

    private fun basketMinusProduct(product: DetailResponse) {
        if (product.productCount == 1){
            viewModel.deleteProduct(product)



            Snackbar.make(
                requireActivity().findViewById(android.R.id.content),
                "You want to remove a product from the basket",
                Snackbar.LENGTH_LONG
            ).apply {
                setAction("No") {
                 viewModel.saveProduct(product)
                }}
                .show()
        }else{
            viewModel.btnMinus(product)
        }

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




