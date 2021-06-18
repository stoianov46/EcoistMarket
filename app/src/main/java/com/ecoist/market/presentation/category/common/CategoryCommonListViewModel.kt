package com.ecoist.market.presentation.category.common

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ecoist.market.data.model.Category
import com.ecoist.market.data.roomdb.CategoryModel
import com.ecoist.market.data.roomdb.CategoryRepositoryEco
import com.ecoist.market.domain.repository.CategoryRepository
import com.ecoist.market.presentation.base.BaseViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CategoryCommonListViewModel(
    application: Application,
    private val repository: CategoryRepository, private val repo: CategoryRepositoryEco
) : BaseViewModel(application) {

    val categoryListLiveData: LiveData<List<Category>>
        get() = categoryListEmitter

    private val categoryListEmitter = MutableLiveData<List<Category>>()

    val categoryListLiveDataRoom: LiveData<List<CategoryModel>>
        get() = categoryListEmitterRoom

    private val categoryListEmitterRoom = MutableLiveData<List<CategoryModel>>()

    val categoryListLiveDataXXX = repo.livedate

    fun init(parentCategoryId: Long) {
        viewModelScope.launch(io) {
            val commonLevelCategory = repository.getChildCategoriesOf(parentCategoryId)
            withContext(main) {
                categoryListEmitter.value = commonLevelCategory
            }
        }
    }

    fun coffeFilter(parentCategoryId: Long) {
        viewModelScope.launch(io) {
            val commonLevelCategory = repo.getChildCategoriesOfRoom(parentCategoryId)
            repo.dao.insert(*commonLevelCategory.toTypedArray())
//            withContext(main) {
//                //categoryListLiveDataXXX.value=commonLevelCategory
//                categoryListEmitterz.value = commonLevelCategory
//            }
        }
    }
}
