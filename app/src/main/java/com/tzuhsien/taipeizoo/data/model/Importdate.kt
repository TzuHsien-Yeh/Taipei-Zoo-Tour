package com.tzuhsien.taipeizoo.data.model

import com.google.gson.annotations.SerializedName

data class ImportDate(
    val date: String,
    val timezone: String,
    @SerializedName("timezone_type") val timezoneType: Int
)