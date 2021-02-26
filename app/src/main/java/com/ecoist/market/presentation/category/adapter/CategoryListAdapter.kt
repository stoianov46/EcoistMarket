package com.ecoist.market.presentation.category.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ecoist.market.R
import com.ecoist.market.data.model.Category

/**
 * Created by Kirill Stoianov on 26/09/2020.
 */
class CategoryListAdapter(
    private var listener: Listener
) : ListAdapter<Category, CategoryListAdapter.CategoryVH>(diff) {

    companion object {
        val diff = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem.id == newItem.id && oldItem.idParent == newItem.idParent
            }

            override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_category_list_item, parent, false)
        return CategoryVH(itemView)
    }


    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        val item = getItem(position)
        if (item != null) holder.bind(item, listener)
    }


    class CategoryVH(view: View) : RecyclerView.ViewHolder(view) {

        private var tvCategoryName: TextView? = view.findViewById(R.id.tvCategoryName)

        fun bind(category: Category, listener: Listener) {
            tvCategoryName?.text = category.name
            itemView.setOnClickListener {
                listener.onClick(category)
            }
        }
    }

    interface Listener {
        fun onClick(category: Category)
    }
}