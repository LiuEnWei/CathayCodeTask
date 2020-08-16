package com.wayne.cathaycodetask.ui

import androidx.lifecycle.MutableLiveData
import com.wayne.cathaycodetask.ui.base.BaseViewModel

class MainViewModel: BaseViewModel() {
    val title = MutableLiveData<String>()
    val isToolbarShow = MutableLiveData<Boolean>()

    fun setTitle(title: String) {
        this.title.postValue(title)
    }

    fun setToolbarShow(isShow: Boolean) {
        isToolbarShow.postValue(isShow)
    }
}