package com.ecoist.market.presentation.product.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.ecoist.market.R
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
            .inflate(R.layout.product_list_item, parent, false)
        return ProductVh(
            productView
        )
    }

    override fun onBindViewHolder(holder: ProductVh, position: Int) {
        val item =
            getItem(position)
        if (item != null) holder.bind(item, listener)
    }

    class ProductVh(view: View) : RecyclerView.ViewHolder(view) {
        private var tvProductName: TextView? = view.findViewById(R.id.tvProductName)
        private var tvProductTextView: TextView? = view.findViewById(R.id.tvProductText)
        private val myImageView : ImageView? = itemView.findViewById(R.id.tvImageView)
        var url="https://ecoist.com.ua/salemod_img/akkumuljatornaja-batareja-alva-6fm100agm-12v-100ah.htm"
        fun bind(product: Product, listener: Listener) {
            tvProductName?.text = product.name
            tvProductTextView?.text = product.descriptionFull
            myImageView?.context?.let { Glide.with(it).load(url).into(myImageView) }
            itemView.setOnClickListener { listener.onClick(product) }
        }
    }

    interface Listener {
        fun onClick(product: Product)
    }
}
