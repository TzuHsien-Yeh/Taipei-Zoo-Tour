package com.tzuhsien.taipeizoo.data.source

import com.tzuhsien.taipeizoo.data.Result
import com.tzuhsien.taipeizoo.data.model.AnimalResult
import com.tzuhsien.taipeizoo.data.model.AreaResult
import com.tzuhsien.taipeizoo.data.model.ResultAnimal

class FakeZooRepository : ZooRepository {

    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean) {
        shouldReturnNetworkError = value
    }

    override suspend fun getAreaInfo(): Result<AreaResult> {
        return if (shouldReturnNetworkError) {
            Result.Fail("Error")
        } else {
            Result.Success(AreaResult(com.tzuhsien.taipeizoo.data.model.Result(0,
                0,
                0,
                listOf(),
                "a")))
        }
    }

    override suspend fun getAnimalInfo(): Result<AnimalResult> {
        return if (shouldReturnNetworkError) {
            Result.Fail("Error")
        } else {
            Result.Success(AnimalResult(ResultAnimal(0, 0, 0, listOf(), "a")))
        }
    }
}