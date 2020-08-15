package com.wayne.cathaycodetask.model.api

import com.wayne.cathaycodetask.model.api.vo.Plant
import com.wayne.cathaycodetask.model.api.vo.TaipeiDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TaipeiZooService {

    @GET("api/v1/dataset/f18de02f-b6c9-47c0-8cda-50efad621c14")
    suspend fun getPlant(@Query("q") query: String,
                      @Query("limit") limit: Int,
                      @Query("offset") offset: Int,
                      @Query("scope") scope: String): TaipeiDataResponse<Plant>
}