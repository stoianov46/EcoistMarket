package com.ecoist.market.di.category

import com.ecoist.market.presentation.category.CategoryListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Kirill Stoianov on 27/09/2020.
 */
fun categoryListModule() = module {
    viewModel {
        CategoryListViewModel(
            application = androidApplication(),
            repository = get()
        )
    }
}