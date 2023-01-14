package com.tzuhsien.taipeizoo.data.source

import com.tzuhsien.taipeizoo.data.model.AreaResult
import com.tzuhsien.taipeizoo.data.Result
import com.tzuhsien.taipeizoo.data.model.AnimalResult

class DefaultZooRepository (
    private val zooRemoteDataSource: ZooDataSource
) : ZooRepository {

    override suspend fun getAreaInfo(): Result<AreaResult> {
        return zooRemoteDataSource.getAreaInfo()
    }

    override suspend fun getAnimalInfo(): Result<AnimalResult> {
        return zooRemoteDataSource.getAnimalInfo()
    }
}
