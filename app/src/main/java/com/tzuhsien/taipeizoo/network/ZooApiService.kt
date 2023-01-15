package com.tzuhsien.taipeizoo.network

import com.tzuhsien.taipeizoo.data.model.AnimalResult
import com.tzuhsien.taipeizoo.data.model.AreaResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val ENDPOINT = "dataset/"
private const val PATH = "resource_id"

interface ZooApiService {

    @GET("$ENDPOINT{resource_id}")
    suspend fun getAreaInfo(
        @Path("resource_id") resourceId: String,
        @Query("scope") scope: String
    ): AreaResult

    @GET("$ENDPOINT{resource_id}")
    suspend fun getAnimalInfo(
        @Path("resource_id") resourceId: String,
        @Query("scope") scope: String
    ): AnimalResult
}