package com.tzuhsien.taipeizoo.area

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzuhsien.taipeizoo.R
import com.tzuhsien.taipeizoo.data.Result
import com.tzuhsien.taipeizoo.data.model.Animal
import com.tzuhsien.taipeizoo.data.model.AnimalResult
import com.tzuhsien.taipeizoo.data.model.Area
import com.tzuhsien.taipeizoo.data.source.ZooRepository
import com.tzuhsien.taipeizoo.network.LoadApiStatus
import com.tzuhsien.taipeizoo.util.Util.getString
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class AreaViewModel(
    private val zooRepository: ZooRepository,
    val area: Area
) : ViewModel() {

    private val _AnimalList = MutableLiveData<List<Animal>>()
    val AnimalList: LiveData<List<Animal>>
        get() = _AnimalList

    private val _status = MutableLiveData<LoadApiStatus>()
    val status: LiveData<LoadApiStatus>
        get() = _status

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?>
        get() = _error

    val uiState = AreaUiState(
        onClick = {
            navigateToAnimalPage(it)
        }
    )

    private val  _navigateToAnimal = MutableLiveData<Animal>()
    val  navigateToAnimal: LiveData<Animal>
        get() =  _navigateToAnimal

    init {
        getAreaInfo()
    }

    private fun getAreaInfo() {

        viewModelScope.launch {

            _status.value = LoadApiStatus.LOADING

            val result = withContext(Dispatchers.IO) {
                zooRepository.getAnimalInfo()
            }

            when (result) {
                is Result.Success -> {
                    _error.value = null
                    _status.value = LoadApiStatus.DONE

                    Timber.d("result.data = ${result.data}")
                    putToItemList(result.data)
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

    private fun putToItemList(data: AnimalResult) {
        val list = mutableListOf<Animal>()
        for (a in data.result.results) {
            list.add(a)
        }

        Timber.d("list $list")
        Timber.d("list.filter { it.aLocation == area.eName } = ${list.filter { it.aLocation == area.eName }}")
        _AnimalList.value = list.filter { it.aLocation == area.eName }

    }

    private fun navigateToAnimalPage(animal: Animal) {
        _navigateToAnimal.value = animal
    }

}

data class AreaUiState (
    val onClick: (Animal) -> Unit
)