package com.ecoist.market.di.repository

import com.ecoist.market.domain.repository.CategoryRepository
import com.ecoist.market.domain.repository.ProductRepository
import org.koin.dsl.module

/**
 * Created by Kirill Stoianov on 18/09/2020.
 */
fun repositoryModule() = module {
    factory { CategoryRepository(get()) }
    factory { ProductRepository(get()) }
}