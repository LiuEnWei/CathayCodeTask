package com.wayne.cathaycodetask.model

import android.content.Context
import com.wayne.cathaycodetask.Constant
import com.wayne.cathaycodetask.model.api.TaipeiZooService
import com.wayne.cathaycodetask.model.api.vo.Category
import com.wayne.cathaycodetask.model.api.vo.Plant
import com.wayne.cathaycodetask.model.api.vo.TaipeiDataResponse
import com.wayne.cathaycodetask.utils.CSVUtils

class Repository(private val taipeiZooService: TaipeiZooService) {
    suspend fun getPlant(query: String = "", limit: Int = Constant.PLANT_LIMIT, offset: Int = Constant.PLANT_OFFSET, scope: String = Constant.PLANT_SCOPE): TaipeiDataResponse<Plant> {
        return taipeiZooService.getPlant(query, limit, offset, scope)
    }

    suspend fun getCategory(context: Context): List<Category> {
        return CSVUtils.getCategories(context)
    }
}