package com.tzuhsien.taipeizoo.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzuhsien.taipeizoo.data.Result
import com.tzuhsien.taipeizoo.data.model.AreaResult
import com.tzuhsien.taipeizoo.data.model.Area
import com.tzuhsien.taipeizoo.data.source.ZooRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class HomeViewModel(
    private val zooRepository: ZooRepository
): ViewModel() {

    private val _AreaList = MutableLiveData<List<Area>>()
    val AreaList: LiveData<List<Area>>
        get() = _AreaList

    val uiState = HomeUiState(
        onClick = {
            navigateToAreaPage(it)
        }
    )

    private val  _navigateToArea = MutableLiveData<Area>()
    val  navigateToArea: LiveData<Area>
        get() =  _navigateToArea

    init {
        getAreaInfo()
    }

    private fun getAreaInfo() {

        viewModelScope.launch {

//            _status.value = LoadApiStatus.LOADING

            val result = withContext(Dispatchers.IO) {
               zooRepository.getAreaInfo()
            }

            when (result) {
                is Result.Success -> {
//                    _error.value = null
//                    _status.value = LoadApiStatus.DONE

                    Timber.d("result.data = ${result.data}")
                    putToItemList(result.data)
                }
                is Result.Fail -> {
//                    _error.value = result.error
//                    _status.value = LoadApiStatus.ERROR
                }
                is Result.Error -> {
//                    _error.value = result.exception.toString()
//                    _status.value = LoadApiStatus.ERROR
                }
                else -> {
//                    _error.value = getString(R.string.unknown_error)
//                    _status.value = LoadApiStatus.ERROR
                }
            }
        }
    }

    private fun putToItemList(data: AreaResult) {
        val list = mutableListOf<Area>()
        for (area in data.result.results) {
            list.add(area)
        }

        Timber.d("list $list")
        _AreaList.value = list
    }

    private fun navigateToAreaPage(area: Area) {
        _navigateToArea.value = area
    }

}

data class HomeUiState (
    val onClick: (Area) -> Unit
)