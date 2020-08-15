package com.wayne.cathaycodetask.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wayne.cathaycodetask.model.Repository
import com.wayne.cathaycodetask.model.Result
import com.wayne.cathaycodetask.model.api.vo.Category
import com.wayne.cathaycodetask.ui.base.BaseAndroidViewModel
import kotlinx.coroutines.launch
import org.koin.core.inject

class HomeViewModel(application: Application): BaseAndroidViewModel(application) {
    private val api: Repository by inject()
    private val _categories = MutableLiveData<Result<List<Category>>>()
    val categories: LiveData<Result<List<Category>>>
        get() = _categories

    fun getPlant() {
        viewModelScope.launch {
            _categories.postValue(Result.loading())
            try {
                _categories.postValue(Result.success(api.getCategory(getApplication())))
            } catch (e: Exception) {
                e.printStackTrace()
                _categories.postValue(Result.error(e))
            }
        }
    }
}