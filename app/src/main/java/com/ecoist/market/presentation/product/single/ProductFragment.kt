package com.ecoist.market.presentation.product.single

import android.os.Bundle
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

import com.ecoist.market.R
import com.ecoist.market.data.model.Product
import kotlinx.android.synthetic.main.fragment_product.*
import org.koin.android.ext.android.inject

/**
 * Created by Kirill Stoianov on 26/09/2020.
 */
class ProductFragment : Fragment() {

    private val args: ProductFragmentArgs by navArgs()
    private val viewModel: ProductViewModel by inject()
    private val productObserver = Observer(::handleProduct)

    private var tvProductName: TextView? = null
    private var tvProductDescription: TextView? = null
    private var tvProductDescriptionFull: TextView? = null
    private var tvProductPrice: TextView? = null
    private var tvComment:TextView?=null
    private var tvPhoto:ImageView?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvProductName = view.findViewById(R.id.tvProductName)
        tvProductDescriptionFull = view.findViewById(R.id.tvProductTextFull)
        tvProductDescription = view.findViewById(R.id.tvText)
        tvProductPrice = view.findViewById(R.id.price)
        tvComment=view.findViewById(R.id.tvComent)
        tvPhoto=view.findViewById(R.id.tvImageOfProduct)
        viewModel.productLiveData.observe(viewLifecycleOwner, productObserver)
        viewModel.init(args.product.id)
    }

    private fun handleProduct(product: Product?) {
        if (product == null) return
        tvProductName?.text = product.name
        tvProductPrice?.text = product.price
        tvProductDescriptionFull?.text = product.descriptionFull?.fromHtml()?.trim()
        tvProductDescription?.text = product.description?.fromHtml()?.trim()
        tvComment?.text=product.coment?.fromHtml()?.trim()
        tvPhoto?.context?.let { Glide.with(it).load(product.imageUrl).into(tvImageOfProduct) }
    }

    private fun String.fromHtml(): Spanned {
        return HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}