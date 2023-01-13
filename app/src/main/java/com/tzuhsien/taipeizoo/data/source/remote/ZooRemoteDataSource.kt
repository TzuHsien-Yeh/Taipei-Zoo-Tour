package com.tzuhsien.taipeizoo.data.source.remote

import com.tzuhsien.taipeizoo.data.source.ZooDataSource
import com.tzuhsien.taipeizoo.network.ZooApiService

class ZooRemoteDataSource (private val zooService: ZooApiService) : ZooDataSource {
}