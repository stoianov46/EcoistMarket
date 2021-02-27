package com.ecoist.market.presentation.category.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecoist.market.R
import com.ecoist.market.data.model.Category
import com.ecoist.market.presentation.category.adapter.CategoryListAdapter
import com.ecoist.market.presentation.category.common.CategoryCommonListFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Kirill Stoianov on 26/09/2020.
 */
class CategoryMainListFragment : Fragment(), CategoryListAdapter.Listener {
    lateinit var backToast:Toast
    private var backPressedTime:Long = 0
    private val viewModel: CategoryMainListViewModel by viewModel()
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
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
        viewModel.categoryListLiveData.observe(viewLifecycleOwner, categoryListObserver)
        viewModel.init()
    }

    override fun onClick(category: Category) {
        val builder: NavOptions.Builder = NavOptions.Builder()
        // builder.setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left).build();

        val action =
            CategoryMainListFragmentDirections.actionCategoryListFragmentToCategoryCommonListFragment(
                category = category,
                categoryId = category.id
            )
        findNavController().navigate(action, builder.build())
    }

    private fun handleCategoryList(categoryList: List<Category>?) {
        if (categoryList == null) return
        adapter.submitList(categoryList)
    }


}