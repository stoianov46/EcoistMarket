package com.ecoist.market

import android.app.Application
import com.ecoist.market.di.Koin

/**
 * Created by Kirill Stoianov on 18/09/2020.
 */
class AppDelegate : Application() {

    override fun onCreate() {
        super.onCreate()

        // Init DI
        Koin.start(this)
    }
}