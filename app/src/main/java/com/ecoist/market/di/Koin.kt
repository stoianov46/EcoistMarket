package com.ecoist.market.di

import androidx.annotation.Keep
import com.ecoist.market.AppDelegate
import com.ecoist.market.di.category.categoryListModule
import com.ecoist.market.di.network.networkModule
import com.ecoist.market.di.repository.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.KoinContextHandler
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level

/**
 * Created by Kirill Stoianov on 18/09/2020.
 */
@Keep
object Koin {

    fun start(appDelegate: AppDelegate) {
        val koinApplication = KoinContextHandler.getOrNull()

        if (koinApplication != null) {
            // We already started KoinApplication
            return
        }

        val modules = listOf(
            networkModule(),
            repositoryModule(),
            categoryListModule()
        )

        startKoin {
            androidLogger(Level.NONE)
            androidContext(appDelegate)
            modules(modules)
        }
    }

    fun stop() {
        stopKoin()
    }
}