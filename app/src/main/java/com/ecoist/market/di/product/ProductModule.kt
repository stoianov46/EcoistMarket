package com.ecoist.market.di.product

import com.ecoist.market.presentation.product.single.ProductViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Kirill Stoianov on 12/10/2020.
 */
fun productModule() = module {
    viewModel {
        ProductViewModel(
            application = androidApplication(),
            repository = get()
        )
    }
}