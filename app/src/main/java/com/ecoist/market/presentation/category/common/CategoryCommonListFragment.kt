package com.ecoist.market.presentation.category.common

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
import com.ecoist.market.data.model.Category
import com.ecoist.market.presentation.category.adapter.CategoryListAdapter
import org.koin.android.ext.android.inject

class CategoryCommonListFragment : Fragment(), CategoryListAdapter.Listener {

    private val args: CategoryCommonListFragmentArgs by navArgs()
    private val viewModel: CategoryCommonListViewModel by inject()
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
        viewModel.categoryListLiveData.observe(viewLifecycleOwner, categoryListObserver)
        viewModel.init(args.categoryId)
    }

    override fun onClick(category: Category) {
        val builder: NavOptions.Builder = NavOptions.Builder()
        val action =
            CategoryCommonListFragmentDirections.actionCategoryFragmentToProductFragment2(
                product = ,
                productId = product.id
            )
        findNavController().navigate(action, builder.build())

        TODO("Open ProductListFragment")
    }

    private fun handleCategoryList(categoryList: List<Category>?) {
        if (categoryList == null) return
        adapter.submitList(categoryList)
    }


}