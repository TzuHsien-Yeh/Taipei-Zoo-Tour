package com.tzuhsien.taipeizoo.data.source.remote

import com.tzuhsien.taipeizoo.R
import com.tzuhsien.taipeizoo.data.Result
import com.tzuhsien.taipeizoo.data.model.AreaResult
import com.tzuhsien.taipeizoo.data.source.ZooDataSource
import com.tzuhsien.taipeizoo.network.ZooApiService
import com.tzuhsien.taipeizoo.util.Util.getString
import com.tzuhsien.taipeizoo.util.Util.isInternetConnected
import timber.log.Timber


private const val PATH_AREA = "5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a"
private const val PATH_ANIMAL = "a3e2b221-75e0-45c1-8f97-75acbd43d613"
private const val SCOPE = "resourceAquire"

class ZooRemoteDataSource (private val zooService: ZooApiService) : ZooDataSource {

    override suspend fun getAreaInfo(): Result<AreaResult> {
        if (!isInternetConnected()) {
            return Result.Fail(getString(R.string.internet_not_connected))
        }

        return try {
            val result = zooService.getAreaInfo(PATH_AREA, SCOPE)
            Result.Success(result)

        } catch (e: Exception) {
            Timber.w(" exception=${e.message}")
            Result.Error(e)
        }
    }

}