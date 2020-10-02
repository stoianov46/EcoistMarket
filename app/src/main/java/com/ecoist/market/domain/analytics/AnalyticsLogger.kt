package com.ecoist.market.domain.analytics

/**
 * Created by Kirill Stoianov on 26/09/2020.
 */
object AnalyticsLogger {

    fun logException(throwable: Throwable) {
        throwable.printStackTrace()
    }
}