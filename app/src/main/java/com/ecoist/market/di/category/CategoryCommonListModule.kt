package com.ecoist.market.di.category

import com.ecoist.market.presentation.category.common.CategoryCommonListViewModel
import com.ecoist.market.presentation.category.main.CategoryMainListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Kirill Stoianov on 10/2/20.
 */
fun categoryCommonListModule() = module {
    viewModel {
        CategoryCommonListViewModel(
            application = androidApplication(),
            repository = get()
        )
    }
}