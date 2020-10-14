package com.pavelrukin.asosstore.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pavelrukin.asosstore.R
import com.pavelrukin.asosstore.databinding.MainFragmentBinding
import com.pavelrukin.asosstore.model.product.Product
import com.pavelrukin.asosstore.utils.Constants.Companion.QUERY_PAGE_SIZE
import com.pavelrukin.asosstore.utils.Resource
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding:MainFragmentBinding

    lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fetchList()
        initRecyclerView()

    }
    private fun initRecyclerView() {
        productAdapter = ProductAdapter { product:Product -> toDetailFragment(product) }
        rv_product.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun toDetailFragment(product: Product) {
        TODO("Not yet implemented")
    }

    fun fetchList() {
        viewModel.productList.observe(
            viewLifecycleOwner, Observer { response ->
                when (response) {
                    is Resource.Success -> {
                        hideProgressBar()
                        response.data?.let { result ->
                            productAdapter.differ.submitList(result.products.toList())
                        }
                    }
                    is Resource.Error -> {
                        hideProgressBar()
                        response.message?.let { message ->
                            Toast.makeText(activity, "An error : $message", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                    is Resource.Loading -> {
                        showProgressBar()
                    }
                }
            })
    }

    private fun hideProgressBar() {
        progress_bar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }
}