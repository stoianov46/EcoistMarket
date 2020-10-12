package com.ecoist.market.presentation.product.single

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ecoist.market.data.model.Product
import com.ecoist.market.domain.repository.ProductRepository
import com.ecoist.market.presentation.base.BaseViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductViewModel(
    application: Application,
    private val repository: ProductRepository
) :
    BaseViewModel(application) {

    val productLiveData: LiveData<Product>
        get() = productEmitter

    private val productEmitter = MutableLiveData<Product>()

    fun init(productId: Long) {
        viewModelScope.launch(io) {
            val productList = repository.getProductById(productId)
            withContext(main) {
                productEmitter.value = productList
            }
        }
    }
}
