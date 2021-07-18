package com.ecoist.market.di.product

import com.ecoist.market.presentation.product.single.ProductViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun productModule() = module {
    viewModel {
        ProductViewModel(
            application = androidApplication(),
            repository = get(),
            repos = get(),
            reposik = get()
        )
    }
}