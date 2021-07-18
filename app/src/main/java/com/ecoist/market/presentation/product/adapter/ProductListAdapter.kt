package com.ecoist.market.presentation.product.adapter

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
import com.ecoist.market.data.roomdb.ProductModel

class ProductListAdapter(
    private var listener: Listener
) : ListAdapter<ProductModel, ProductListAdapter.ProductVH>(diff) {

    companion object {
        val diff = object : DiffUtil.ItemCallback<ProductModel>() {
            override fun areItemsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
                return oldItem.id == newItem.id && oldItem.idCategory == newItem.idCategory
            }

            override fun areContentsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        val productView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_item, parent, false)
        return ProductVH(productView)
    }

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        val item = getItem(position)
        if (item != null) holder.bind(item, listener)
    }

    class ProductVH(view: View) : RecyclerView.ViewHolder(view) {
        private var tvProductName: TextView? = view.findViewById(R.id.tvProductName)
        private var tvProductTextView: TextView? = view.findViewById(R.id.priceItems)
        private val productImage: ImageView? = itemView.findViewById(R.id.product_image_view_Item)

        fun bind(product: ProductModel, listener: Listener) {
            tvProductName?.text = product.name
            tvProductTextView?.text = product.price

            productImage?.context?.let {
              Glide.with(it).load(product.imageUrl).into(productImage)
            }
            itemView.setOnClickListener { listener.onClick(product) }
        }
    }

    interface Listener {
        fun onClick(product: ProductModel)
    }
}
