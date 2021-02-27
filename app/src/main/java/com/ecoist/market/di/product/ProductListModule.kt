package com.ecoist.market.di.product

import com.ecoist.market.presentation.category.common.CategoryCommonListViewModel
import com.ecoist.market.presentation.product.list.ProductListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Kirill Stoianov on 12/10/2020.
 */
fun productListModule() = module {
    viewModel {
        ProductListViewModel(
            application = androidApplication(),
            repository = get()
        )
    }
}