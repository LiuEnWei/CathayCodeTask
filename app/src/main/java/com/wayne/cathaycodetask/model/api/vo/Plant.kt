package com.wayne.cathaycodetask.model.api.vo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * 實際參數更多，僅擷取需要用到的
 * 該API有奇怪的字符...
 * */
data class Plant(
    @SerializedName("F_Pic01_URL") val picUrl: String?,
    @SerializedName("F_Pic01_ALT") val picAlt: String?,
    @SerializedName("\uFEFFF_Name_Ch") val nameCh: String?,
    @SerializedName("F_Name_Latin") val nameLatin: String?,
    @SerializedName("F_AlsoKnown") val alsoKnow: String?,
    @SerializedName("F_Brief") val brief: String?,
    @SerializedName("F_Feature") val feature: String?,
    @SerializedName("F_Family") val family: String?,
    @SerializedName("F_Genus") val genus: String?,
    @SerializedName("F_Function＆Application") val use: String?,
    @SerializedName("F_Update") val update: String?): Serializable