package com.tzuhsien.taipeizoo.data.source

import com.tzuhsien.taipeizoo.data.source.remote.ZooRemoteDataSource
import com.tzuhsien.taipeizoo.network.ZooApiService

class DefaultZooRepository (
    private val remoteDataSource: ZooDataSource
) : ZooRepository {}
