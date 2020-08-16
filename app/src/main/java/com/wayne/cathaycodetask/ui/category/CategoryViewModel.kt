package com.wayne.cathaycodetask.ui.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wayne.cathaycodetask.Constant
import com.wayne.cathaycodetask.model.Repository
import com.wayne.cathaycodetask.model.Result
import com.wayne.cathaycodetask.model.api.vo.Plant
import com.wayne.cathaycodetask.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.inject

class CategoryViewModel: BaseViewModel() {
    private val api: Repository by inject()
    private val _plants = MutableLiveData<Result<List<Plant>>>()
    val plants: LiveData<Result<List<Plant>>>
        get() = _plants

    /**
     * 有些植物地區被歸類在「全園普遍分佈」
     * 因此將這些資料加入
     * */
    fun getPlant(name: String) {
        viewModelScope.launch {
            _plants.postValue(Result.loading())
            try {
                val plants = arrayListOf<Plant>()
                val categoryPlants: List<Plant> = api.getPlant(name).result.results
                plants.addAll(categoryPlants)
                val allCategoryPlants = api.getPlant(Constant.ALL_CATEGORY).result.results
                plants.addAll(allCategoryPlants)
                Log.e("CategoryViewModel","getPlant : ${plants.size}")
                Log.e("CategoryViewModel","getPlant : $plants")
                _plants.postValue(Result.success(plants))
            } catch (e: Exception) {
                e.printStackTrace()
                _plants.postValue(Result.error(e))
            }
        }
    }

}