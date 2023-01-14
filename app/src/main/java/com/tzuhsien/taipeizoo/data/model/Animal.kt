package com.tzuhsien.taipeizoo.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Animal(
    @SerializedName("_id") val id: Int,
    @SerializedName("a_alsoknown") val aAlsoKnown: String,
    @SerializedName("a_behavior") val aBehavior: String,
    @SerializedName("a_feature") val aFeature: String,
    @SerializedName("a_location") val aLocation: String,
    @SerializedName("a_name_ch") val aNameCh: String,
    @SerializedName("a_name_latin") val aNameLatin: String,
    @SerializedName("a_pic01_url") val aPic01Url: String,
    @SerializedName("a_update") val aUpdate: String
): Parcelable