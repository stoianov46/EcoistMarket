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
import com.ecoist.market.data.model.Product

class ProductListAdapter(
    private var listener: Listener
) : ListAdapter<Product, ProductListAdapter.ProductVh>(diff) {
    companion object {
        val diff = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.id == newItem.id && oldItem.idCategory == newItem.idCategory
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVh {
        val productView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_product_list, parent, false)
        return ProductVh(productView)
    }


    override fun onBindViewHolder(holder: ProductVh, position: Int) {
        val item = getItem(position)
        if (item != null) holder.bind(item, listener)
    }

    class ProductVh(view: View) : RecyclerView.ViewHolder(view) {
        private var tvProductName: TextView? = view.findViewById(R.id.tvProductName)

        fun bind(product: Product, listener: Listener) {
            tvProductName?.text = product.name
            itemView.setOnClickListener { listener.onClick(product) }
        }
    }

    interface Listener {
        fun onClick(product: Product)
    }
}
