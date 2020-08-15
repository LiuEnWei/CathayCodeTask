package com.wayne.cathaycodetask.ui.adapter

import androidx.navigation.Navigator
import com.wayne.cathaycodetask.model.api.vo.Category

interface OnCategoryClickListener {
    fun onClick(category: Category, extras: Navigator.Extras)
}