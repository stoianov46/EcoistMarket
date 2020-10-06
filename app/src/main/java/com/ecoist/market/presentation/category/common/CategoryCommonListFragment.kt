package com.ecoist.market.presentation.category.common

import android.net.Proxy
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.ecoist.market.data.model.Category
import com.ecoist.market.presentation.category.adapter.CategoryListAdapter
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecoist.market.R
import com.ecoist.market.data.model.Product

class CategoryCommonListFragment : Fragment(), CategoryListAdapter.Listener {

    private val args: CategoryCommonListViewModel by navArgs()
    private val categoryListObserver = Observer<List<Category>>(::handleCategoryList)

    private var recyclerView: RecyclerView? = null
    private val adapter = CategoryListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category_main_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView?.adapter = adapter;
        recyclerView?.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.VERTICAL, false);
        args.categoryListLiveData.observe(viewLifecycleOwner, categoryListObserver)
        args.init()
    }

    override fun onClick(product: Product) {
        val builder: NavOptions.Builder = NavOptions.Builder()
        val action =
            CategoryCommonListFragmentDirections.actionCategoryFragmentToProductFragment2(
                product = product,
                productId = product.id
            )
        findNavController().navigate(action, builder.build())
    }

    private fun handleCategoryList(categoryList: List<Category>?) {
        if (categoryList == null) return
        adapter.submitList(categoryList)
    }




}