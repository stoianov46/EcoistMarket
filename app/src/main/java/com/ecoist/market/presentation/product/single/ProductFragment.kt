package com.ecoist.market.presentation.product.single

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecoist.market.R
import com.ecoist.market.data.model.Photo
import com.ecoist.market.data.model.Product
import com.ecoist.market.databinding.FragmentProductBinding
import org.koin.android.ext.android.inject


class ProductFragment : Fragment() {
    private lateinit var bind: FragmentProductBinding
    private val args: ProductFragmentArgs by navArgs()
    private val viewModel: ProductViewModel by inject()
    private val productObserver = Observer(::handleProduct)
    private val photoObserver = Observer<List<Photo>>(::handlePhoto)
    private var recyclerView: RecyclerView? = null
    private var tvProductName: TextView? = null
    private var tvProductDescription: TextView? = null
    private var tvProductDescriptionFull: TextView? = null
    private var tvProductPrice: TextView? = null
    private var tvProductPriceCena: TextView? = null
    private var tvComment: TextView? = null
    private var tvTextX: TextView? = null
    private var tvComentX: TextView? = null
    private var tvProductTextFullX: TextView? = null
    private val listAdapter = PhotoListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind=DataBindingUtil.inflate(inflater, R.layout.fragment_product, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var str= args.product.id
        bind.button.setOnClickListener {
            val uri: Uri =
                Uri.parse("http://www.ecoist.com.ua/"+str) // missing 'http://' will cause crashed

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        tvProductName = view.findViewById(R.id.tvProductName)
        tvProductDescriptionFull = view.findViewById(R.id.tvProductTextFull)
        tvProductDescription = view.findViewById(R.id.tvText)
        tvProductPrice = view.findViewById(R.id.price)
        tvProductPriceCena = view.findViewById(R.id.priceName)
        tvComment = view.findViewById(R.id.tvComment)
        tvProductTextFullX = view.findViewById(R.id.tvProductTextFullX)
        tvTextX = view.findViewById(R.id.tvTextX)
        tvComentX = view.findViewById(R.id.tvComentX)
        recyclerView = view.findViewById(R.id.photo_recycler)
        recyclerView?.adapter = listAdapter
        recyclerView?.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
        viewModel.productLiveData.observe(viewLifecycleOwner, productObserver)
        viewModel.photoLiveData.observe(viewLifecycleOwner, photoObserver)
        viewModel.loadPhoto(args.product.urlForImages)
        viewModel.init(args.product.id)
    }

    private fun handleProduct(product: Product?) {
        if (product == null) return
        tvProductName?.text = product.name
        tvProductPrice?.text = product.price
        tvProductDescriptionFull?.text = product.descriptionFull?.fromHtml()?.trim()
        tvProductDescription?.text = product.description?.fromHtml()?.trim()
        tvComment?.text = product.coment?.fromHtml()?.trim()
    }

    private fun handlePhoto(ph: List<Photo>?) {
        if (ph == null) return
        listAdapter?.submitList(ph)
    }

    private fun String.fromHtml(): Spanned {
        return HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

}
