package com.ecoist.market.di.repository

import com.ecoist.market.domain.CategoryRepository
import com.ecoist.market.domain.ProductRepository
import org.koin.dsl.module

/**
 * Created by Kirill Stoianov on 18/09/2020.
 */
fun repositoryModule() = module {
    factory { CategoryRepository( get()) }
    factory { ProductRepository(get()) }
}