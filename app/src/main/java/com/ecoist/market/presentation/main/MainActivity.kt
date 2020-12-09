package com.ecoist.market.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.ecoist.market.R
import com.ecoist.market.domain.analytics.AppLogger

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG: String = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppLogger.debug(TAG, "onCreate()")
        setContentView(R.layout.activity_main)
        findNavController(R.id.navHostFragment).navigate(R.id.splashFragment)

    }
}