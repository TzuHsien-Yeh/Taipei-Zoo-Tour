package com.tzuhsien.taipeizoo.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Animal(
    @SerializedName("_id") val id: Int,
    @SerializedName("_importdate") val importDate: @RawValue ImportDate,
    @SerializedName("a_adopt") val aAdopt: String,
    @SerializedName("a_alsoknown") val aAlsoKnown: String,
    @SerializedName("a_behavior") val aBehavior: String,
    @SerializedName("a_cid") val aCid: String,
    @SerializedName("a_class") val aClass: String,
    @SerializedName("a_code") val aCode: String,
    @SerializedName("a_conservation") val aConservation: String,
    @SerializedName("a_crisis") val aCrisis: String,
    @SerializedName("a_diet") val aDiet: String,
    @SerializedName("a_distribution") val aDistribution: String,
    @SerializedName("a_family") val aFamily: String,
    @SerializedName("a_feature") val aFeature: String,
    @SerializedName("a_geo") val aGeo: String,
    @SerializedName("a_habitat") val aHabitat: String,
    @SerializedName("a_interpretation") val aInterpretation: String,
    @SerializedName("a_keywords") val aKeywords: String,
    @SerializedName("a_location") val aLocation: String,
    @SerializedName("a_name_ch") val aNameCh: String,
    @SerializedName("a_name_en") val aNameEn: String,
    @SerializedName("a_name_latin") val aNameLatin: String,
    @SerializedName("a_order") val aOrder: String,
//    @SerializedName("a_") val aPdf01Alt: String,
//    @SerializedName("a_") val aPdf01Url: String,
//    @SerializedName("a_") val aPdf02Alt: String,
//    @SerializedName("a_") val aPdf02Url: String,
    @SerializedName("a_phylum") val aPhylum: String,
//    @SerializedName("a_") val aPic01Alt: String,
    @SerializedName("a_pic01_url") val aPic01Url: String,
//    @SerializedName("a_") val aPic02Alt: String,
//    @SerializedName("a_") val aPic02Url: String,
//    @SerializedName("a_") val aPic03Alt: String,
//    @SerializedName("a_") val aPic03Url: String,
//    @SerializedName("a_") val aPic04Alt: String,
//    @SerializedName("a_") val aPic04Url: String,
//    @SerializedName("a_") val aPoigroup: String,
    @SerializedName("a_summary") val aSummary: String,
//    @SerializedName("a_") val aThemeName: String,
//    @SerializedName("a_") val aThemeUrl: String,
    @SerializedName("a_update") val aUpdate: String,
//    @SerializedName("a_") val aVedioUrl: String,
//    @SerializedName("a_") val aVoice01Alt: String,
//    @SerializedName("a_") val aVoice01Url: String,
//    @SerializedName("a_") val aVoice02Alt: String,
//    @SerializedName("a_") val aVoice02Url: String,
//    @SerializedName("a_") val aVoice03Alt: String,
//    @SerializedName("a_") val aVoice03Url: String
): Parcelable