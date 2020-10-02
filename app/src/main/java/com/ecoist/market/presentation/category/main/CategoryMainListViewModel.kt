package com.ecoist.market.presentation.category.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ecoist.market.data.model.Category
import com.ecoist.market.domain.repository.CategoryRepository
import com.ecoist.market.presentation.base.BaseViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by Kirill Stoianov on 27/09/2020.
 */
class CategoryMainListViewModel(
    application: Application,
    private val repository: CategoryRepository
) : BaseViewModel(application) {

    val categoryListLiveData: LiveData<List<Category>>
        get() = categoryListEmitter

    private val categoryListEmitter = MutableLiveData<List<Category>>()

    fun init() {
        viewModelScope.launch(io) {
            val topLevelCategories = repository.getTopLevelCategories()
            withContext(main) {
                categoryListEmitter.value = topLevelCategories
            }
        }
    }
}