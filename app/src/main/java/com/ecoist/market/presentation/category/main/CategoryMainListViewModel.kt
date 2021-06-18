package com.ecoist.market.presentation.category.main

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


class CategoryMainListViewModel(
    application: Application,
    private val repository: CategoryRepository, private val repo: CategoryRepositoryEco
) : BaseViewModel(application) {

    val categoryListLiveData: LiveData<List<Category>>
        get() = categoryListEmitter
    private val categoryListEmitter = MutableLiveData<List<Category>>()


    val categoryListLiveDataRoom: LiveData<List<CategoryModel>>
        get() = categoryListEmitterRoom
    private val categoryListEmitterRoom = MutableLiveData<List<CategoryModel>>()

  //  val categoryListLiveDataFromRoom = repo.livedate

    fun init() {
        viewModelScope.launch(io) {
            val topLevelCategories = repository.getTopLevelCategories()
            withContext(main) {
                categoryListEmitter.value = topLevelCategories
            }
        }
    }

    fun initMain() {
        viewModelScope.launch(io) {
            val topLevelCategoriesz =  repo.getTopLevelCategoriesRoom()
            withContext(main) {
                categoryListEmitterRoom.value = topLevelCategoriesz
            }
        }

    }

}