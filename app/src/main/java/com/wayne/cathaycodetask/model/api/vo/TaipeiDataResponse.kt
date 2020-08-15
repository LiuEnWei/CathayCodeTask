package com.wayne.cathaycodetask.model.api.vo

import com.google.gson.annotations.SerializedName

data class TaipeiDataResponse<T>(@SerializedName("result") val result: TaipeiDataResult<T>)