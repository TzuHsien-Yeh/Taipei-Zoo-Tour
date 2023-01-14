package com.tzuhsien.taipeizoo.area

import androidx.lifecycle.ViewModel
import com.tzuhsien.taipeizoo.data.model.Area
import com.tzuhsien.taipeizoo.data.source.ZooRepository
import timber.log.Timber

class AreaViewModel(
    private val zooRepository: ZooRepository,
    val area: Area
) : ViewModel() {

    init {
        Timber.d("passed in $area")
    }
}