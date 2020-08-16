package com.wayne.cathaycodetask.ui

import androidx.lifecycle.MutableLiveData
import com.wayne.cathaycodetask.ui.base.BaseViewModel

class MainViewModel: BaseViewModel() {
    val title = MutableLiveData<String>()

    fun setTitle(title: String) {
        this.title.postValue(title)
    }
}