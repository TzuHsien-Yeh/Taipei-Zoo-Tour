package com.tzuhsien.taipeizoo.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzuhsien.taipeizoo.R
import com.tzuhsien.taipeizoo.data.Result
import com.tzuhsien.taipeizoo.data.model.AreaResult
import com.tzuhsien.taipeizoo.data.model.Area
import com.tzuhsien.taipeizoo.data.source.ZooRepository
import com.tzuhsien.taipeizoo.network.LoadApiStatus
import com.tzuhsien.taipeizoo.util.Util.getString
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class HomeViewModel(
    private val zooRepository: ZooRepository
): ViewModel() {

    var areaData: AreaResult? = null

    private val _areaList = MutableLiveData<List<Area>>()
    val areaList: LiveData<List<Area>>
        get() = _areaList

    val uiState = HomeUiState(
        onClick = {
            navigateToAreaPage(it)
        }
    )

    private val  _navigateToArea = MutableLiveData<Area>()
    val  navigateToArea: LiveData<Area>
        get() =  _navigateToArea

    private val _status = MutableLiveData<LoadApiStatus>()
    val status: LiveData<LoadApiStatus>
        get() = _status

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?>
        get() = _error

    init {
        getAreaInfo()
    }

    fun getAreaInfo() {

        viewModelScope.launch {

            _status.value = LoadApiStatus.LOADING

            val result = withContext(Dispatchers.IO) {
               zooRepository.getAreaInfo()
            }

            when (result) {
                is Result.Success -> {
                    _error.value = null
                    _status.value = LoadApiStatus.DONE

                    Timber.d("result.data = ${result.data}")
                    areaData = result.data
                    putToItemList()
                }
                is Result.Fail -> {
                    _error.value = result.error
                    _status.value = LoadApiStatus.ERROR
                }
                is Result.Error -> {
                    _error.value = result.exception.toString()
                    _status.value = LoadApiStatus.ERROR
                }
                else -> {
                    _error.value = getString(R.string.unknown_error)
                    _status.value = LoadApiStatus.ERROR
                }
            }
        }
    }

    fun putToItemList() {
        areaData?.let {
            val list = mutableListOf<Area>()
            for (area in it.result.results) {
                list.add(area)
            }

            Timber.d("list $list")
            _areaList.value = list
        }
    }

    fun navigateToAreaPage(area: Area) {
        _navigateToArea.value = area
    }

}

data class HomeUiState (
    val onClick: (Area) -> Unit
)