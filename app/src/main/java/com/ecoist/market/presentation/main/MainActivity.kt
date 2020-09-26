package com.ecoist.market.presentation.main

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.ecoist.market.R
import com.ecoist.market.domain.analytics.AnalyticsLogger
import com.ecoist.market.domain.analytics.AppLogger

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG: String = "MainActivity"
    }

    private val fragmentContainerViewId: Int = R.id.fragmentContainer

    private val backPressCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (supportFragmentManager.backStackEntryCount > 1) {
                clearStackFragment()
            } else {
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppLogger.debug(TAG, "onCreate()")
        setContentView(R.layout.activity_main)
        onBackPressedDispatcher.addCallback(backPressCallback)
    }

    private fun stackFragment(fragment: Fragment) {
        AppLogger.debug(TAG, "stackFragment(fragment = ${fragment::class.java.simpleName})")
        this.stackFragment(fragment = fragment, stackName = fragment::class.java.simpleName)
    }

    private fun stackFragment(fragment: Fragment, stackName: String) {
        AppLogger.debug(
            TAG,
            "stackFragment(fragment = ${fragment::class.java.simpleName}, stackName = $stackName)"
        )

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(fragmentContainerViewId, fragment)
        fragmentTransaction.addToBackStack(stackName)
        fragmentTransaction.commitAllowingStateLoss()
    }

    private fun clearStackFragment() {
        AppLogger.debug(TAG, "clearStackFragment()")
        try {
            supportFragmentManager.popBackStackImmediate()
        } catch (throwable: Throwable) {
            AnalyticsLogger.logException(throwable)
        }
    }

    private fun clearStackFragment(stackName: String) {
        AppLogger.debug(TAG, "clearStackFragment(stackName = $stackName)")
        try {
            supportFragmentManager.popBackStackImmediate(
                stackName,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        } catch (throwable: Throwable) {
            AnalyticsLogger.logException(throwable)
        }
    }
}