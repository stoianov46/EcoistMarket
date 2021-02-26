package com.ecoist.market.presentation.product.list

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ecoist.market.data.model.Product
import com.ecoist.market.domain.repository.ProductRepository
import com.ecoist.market.presentation.base.BaseViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductListViewModel(
    application: Application,
    private val repository: ProductRepository
) : BaseViewModel(application) {

    val productListLiveData: LiveData<List<Product>>
        get() = productListEmitter

    private val productListEmitter = MutableLiveData<List<Product>>()

    fun init(commonCategoryId: Long) {
        viewModelScope.launch(io) {
            val productList = repository.getProductsByIdOfCategory(commonCategoryId)
            withContext(main) {
                productListEmitter.value = productList
            }
        }
    }
}
