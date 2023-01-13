package com.tzuhsien.taipeizoo.data

import com.tzuhsien.taipeizoo.data.source.DefaultZooRepository
import com.tzuhsien.taipeizoo.data.source.ZooRepository
import com.tzuhsien.taipeizoo.data.source.remote.ZooRemoteDataSource
import com.tzuhsien.taipeizoo.network.ZooApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val zooRepository: ZooRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://data.taipei/api/v1/dataset/"

    /**
     * Use the Retrofit builder to build a retrofit object using Gson converter
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: ZooApiService by lazy {
        retrofit.create(ZooApiService::class.java)
    }

    // Satisfy the dependencies of UserRepository
    private val remoteDataSource = ZooRemoteDataSource(retrofitService)

    /**
     * DI implementation for Zoo repository
     */
    override val zooRepository: ZooRepository by lazy {
        DefaultZooRepository(remoteDataSource)
    }
}
