package com.wayne.cathaycodetask.ui.adapter

import androidx.navigation.Navigator
import com.wayne.cathaycodetask.model.api.vo.Plant

interface OnPlantClickListener {
    fun onClick(plant: Plant, extras: Navigator.Extras)
}