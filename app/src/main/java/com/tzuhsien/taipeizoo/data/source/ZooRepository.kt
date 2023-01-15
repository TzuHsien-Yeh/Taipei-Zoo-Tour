package com.tzuhsien.taipeizoo.data.source

import com.tzuhsien.taipeizoo.data.model.AreaResult
import com.tzuhsien.taipeizoo.data.Result
import com.tzuhsien.taipeizoo.data.model.AnimalResult

interface ZooRepository {

    suspend fun getAreaInfo(): Result<AreaResult>

    suspend fun getAnimalInfo(): Result<AnimalResult>
}