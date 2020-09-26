package com.ecoist.market.presentation.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by Kirill Stoianov on 26/09/2020.
 */
abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    protected val io: CoroutineDispatcher
        get() = Dispatchers.IO

    protected val main: CoroutineDispatcher
        get() = Dispatchers.Main
}