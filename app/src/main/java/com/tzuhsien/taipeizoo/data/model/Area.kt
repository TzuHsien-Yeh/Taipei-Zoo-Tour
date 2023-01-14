package com.tzuhsien.taipeizoo.data.model

import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Area(
    @SerializedName("_id") val id: Int,
    @SerializedName("e_category") val eCategory: String,
    @SerializedName("e_info") val eInfo: String,
    @SerializedName("e_name") val eName: String,
    @SerializedName("e_pic_url") val ePicUrl: String,
    @SerializedName("e_url") val eUrl: String,
): Parcelable