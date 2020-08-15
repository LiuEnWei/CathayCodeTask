package com.wayne.cathaycodetask.model.api.vo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Category (
    @SerializedName("category") val category: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("picUrl") val picUrl: String?,
    @SerializedName("info") val info: String?,
    @SerializedName("memo") val memo: String?,
    @SerializedName("url") val url: String?): Serializable