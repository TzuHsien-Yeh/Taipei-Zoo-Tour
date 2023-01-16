package com.tzuhsien.taipeizoo.data.source

import com.tzuhsien.taipeizoo.data.Result
import com.tzuhsien.taipeizoo.data.model.*

class FakeZooRepository : ZooRepository {

    var areaResult = AreaResult(com.tzuhsien.taipeizoo.data.model.Result(0,
        0,
        0,
        listOf(
            Area(0, "a", "b", "c", "d", "e")
        ),
        "a"))

    var animalResult = AnimalResult(
        ResultAnimal(0,
            0,
            0,
            listOf(
                Animal(1, "a", "b", "c", "tropical", "e", "f", "g", "h"),
                Animal(2, "a", "b", "c", "d", "e", "f", "g", "h"),
                Animal(3, "a", "b", "c", "tropical", "e", "f", "g", "h"),
                Animal(4, "a", "b", "c", "d", "e", "f", "g", "h")
            ),
            "a"))

    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean) {
        shouldReturnNetworkError = value
    }

    override suspend fun getAreaInfo(): Result<AreaResult> {
        return if (shouldReturnNetworkError) {
            Result.Fail("Error")
        } else {
            Result.Success(areaResult)
        }
    }

    override suspend fun getAnimalInfo(): Result<AnimalResult> {
        return if (shouldReturnNetworkError) {
            Result.Fail("Error")
        } else {
            Result.Success(animalResult)
        }
    }
}