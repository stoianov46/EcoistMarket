package com.ecoist.market.presentation.product.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecoist.market.R
import com.ecoist.market.data.model.Product
import com.ecoist.market.presentation.product.adapter.ProductListAdapter
import org.koin.android.ext.android.inject

class ProductListFragment : Fragment(), ProductListAdapter.Listener {

    private val args: ProductListFragmentArgs by navArgs()
    private val viewModel: ProductListViewModel by inject()
    private val productListObserver = Observer<List<Product>>(::handleProductList)
    private var recyclerView: RecyclerView? = null
    private val adapter =
        ProductListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
        viewModel.productListLiveData.observe(viewLifecycleOwner, productListObserver)
        viewModel.init(args.category.id)
    }

    override fun onClick(product: Product) {
        val builder: NavOptions.Builder = NavOptions.Builder()
        val action =
            ProductListFragmentDirections.actionProductListFragmentToProductFragment(product)
        findNavController().navigate(action, builder.build())
    }

    private fun handleProductList(productList: List<Product>?) {
        if (productList == null) return
        adapter.submitList(productList)
    }
}
