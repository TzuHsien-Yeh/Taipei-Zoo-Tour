package com.tzuhsien.taipeizoo.data.source

import com.tzuhsien.taipeizoo.data.model.AreaResult
import com.tzuhsien.taipeizoo.data.Result

interface ZooDataSource {
    suspend fun getAreaInfo(): Result<AreaResult>
}