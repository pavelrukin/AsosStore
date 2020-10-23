package com.pavelrukin.asosstore.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.pavelrukin.asosstore.R
import com.pavelrukin.asosstore.databinding.DetailFragmentBinding
import com.pavelrukin.asosstore.model.detail_product.DetailResponse
import com.pavelrukin.asosstore.utils.Constants.Companion.IMG_URL
import com.pavelrukin.asosstore.utils.Resource
import com.pavelrukin.asosstore.utils.extensions.replaceHtmlTag
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_fragment.*
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.main_fragment.progress_bar
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : Fragment() {
    val args: DetailFragmentArgs by navArgs()
    private lateinit var binding: DetailFragmentBinding
    private val viewModel: DetailViewModel by viewModel()
    lateinit var detaiAdapter: DetailAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getProductList(args.productId.id)
        fetchDetailProduct()
        detaiAdapter = DetailAdapter()

        fab_to_list.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_mainFragment)
        }
    }

    fun initView(result: DetailResponse) {
        Picasso.get().load(IMG_URL + args.productId.imageUrl).into(binding.detailImage)

        binding.productDetail = result
        binding.tvAboutMe.text = result.info?.aboutMe?.replaceHtmlTag()
        binding.tvCareInfo.text = result.info?.careInfo?.replaceHtmlTag()
        binding.tvPrice.text = result.priceDetail?.current?.text
        binding.rvDetailProduct.apply {
            adapter = detaiAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }
        detaiAdapter.differ.submitList(result.media?.images )

    }

    private fun fetchDetailProduct() {
        viewModel.detailProduct.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                     hideProgressBar()
                    showFab()
                    response.data?.let { result ->
                        initView(result)
                    }
                }
                is Resource.Error -> {
                    hideFab()
                        hideProgressBar()
                    response.message?.let { message ->
                        Toast.makeText(activity, "An error : $message", Toast.LENGTH_LONG)
                            .show()
                    }
                }
                is Resource.Loading -> {
                      showProgressBar()
                    hideFab()
                }
            }
        })

    }
    private fun hideFab(){
        fab_add_product.visibility = View.INVISIBLE
        fab_to_list.visibility = View.INVISIBLE

    }
    private fun showFab(){
        fab_add_product.visibility = View.VISIBLE
        fab_to_list.visibility = View.VISIBLE
    }
    private fun hideProgressBar() {
    progress_bar_detail.visibility = View.INVISIBLE
    }
    private fun showProgressBar() {
       progress_bar_detail.visibility = View.VISIBLE
    }
}