package com.tzuhsien.taipeizoo.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImportDate(
    val date: String,
    val timezone: String,
    @SerializedName("timezone_type") val timezoneType: Int
): Parcelable