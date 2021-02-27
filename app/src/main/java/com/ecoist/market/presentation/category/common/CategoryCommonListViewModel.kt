package com.ecoist.market.presentation.category.common

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ecoist.market.data.model.Category
import com.ecoist.market.domain.repository.CategoryRepository
import com.ecoist.market.presentation.base.BaseViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CategoryCommonListViewModel(
    application: Application,
    private val repository: CategoryRepository
) : BaseViewModel(application) {

    val categoryListLiveData: LiveData<List<Category>>
        get() = categoryListEmitter

    private val categoryListEmitter = MutableLiveData<List<Category>>()

    fun init(parentCategoryId: Long) {
        viewModelScope.launch(io) {
            val commonLevelCategory = repository.getChildCategoriesOf(parentCategoryId)
            withContext(main) {
                categoryListEmitter.value = commonLevelCategory
            }
        }
    }
}
