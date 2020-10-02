package com.ecoist.market.di.category

import com.ecoist.market.presentation.category.main.CategoryMainListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Kirill Stoianov on 27/09/2020.
 */
fun categoryListModule() = module {
    viewModel {
        CategoryMainListViewModel(
            application = androidApplication(),
            repository = get()
        )
    }
}