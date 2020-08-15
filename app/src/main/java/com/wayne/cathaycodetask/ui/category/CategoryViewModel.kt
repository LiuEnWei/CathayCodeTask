package com.wayne.cathaycodetask.ui.category

import com.wayne.cathaycodetask.model.Repository
import com.wayne.cathaycodetask.ui.base.BaseViewModel
import org.koin.core.inject

class CategoryViewModel: BaseViewModel() {
    private val api: Repository by inject()


}