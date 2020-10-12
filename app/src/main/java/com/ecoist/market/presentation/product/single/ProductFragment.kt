package com.ecoist.market.presentation.product.single

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.ecoist.market.R
import com.ecoist.market.data.model.Product
import org.koin.android.ext.android.inject

/**
 * Created by Kirill Stoianov on 26/09/2020.
 */
class ProductFragment : Fragment() {

    private val args: ProductFragmentArgs by navArgs()
    private val viewModel: ProductViewModel by inject()
    private val productObserver = Observer(::handleProduct)

    private var tvProductName: TextView? = null

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
        viewModel.productLiveData.observe(viewLifecycleOwner, productObserver)
        viewModel.init(args.product.id)
    }

    private fun handleProduct(product: Product?) {
        if (product == null) return
        tvProductName?.text = product.name
    }
}