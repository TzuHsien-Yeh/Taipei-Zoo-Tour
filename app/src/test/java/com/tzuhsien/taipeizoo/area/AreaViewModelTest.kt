package com.tzuhsien.taipeizoo.area

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import com.tzuhsien.taipeizoo.MainCoroutineRule
import com.tzuhsien.taipeizoo.data.model.*
import com.tzuhsien.taipeizoo.data.source.FakeZooRepository
import com.tzuhsien.taipeizoo.getOrAwaitValue
import com.tzuhsien.taipeizoo.home.HomeViewModel
import com.tzuhsien.taipeizoo.network.LoadApiStatus
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test


@ExperimentalCoroutinesApi
class AreaViewModelTest {

    private lateinit var areaViewModel: AreaViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()


    private val fakeZooRepository = FakeZooRepository()

    @Before
    fun setupViewModel() {
        areaViewModel = AreaViewModel(fakeZooRepository, Area(0, "a", "b", "tropical", "d", "e"))
    }

    @Test
    fun getAreaInfo_networkError_returnErrorMsg(){
        // Given the situation of network error
        fakeZooRepository.setShouldReturnNetworkError(true)

        areaViewModel.getAnimalInfo()

        assertThat(areaViewModel.error.getOrAwaitValue()).isEqualTo("Error")
        assertThat(areaViewModel.status.getOrAwaitValue()).isEqualTo(LoadApiStatus.ERROR)
        assertThat(areaViewModel.animalData).isEqualTo(null)
    }

    @Test
    fun getAreaInfo_network_returnSuccess(){

        areaViewModel.getAnimalInfo()

        assertThat(areaViewModel.error.getOrAwaitValue()).isEqualTo(null)
        assertThat(areaViewModel.status.getOrAwaitValue()).isNotEqualTo(LoadApiStatus.ERROR)
        assertThat(areaViewModel.animalData).isEqualTo(fakeZooRepository.animalResult)
    }

    @Test
    fun `set only the animals locate in the area to animalList LiveData`() {

        val animals = listOf(
            Animal(1, "a", "b", "c", "tropical", "e", "f", "g", "h"),
            Animal(2, "a", "b", "c", "d", "e", "f", "g", "h"),
            Animal(3, "a", "b", "c", "tropical", "e", "f", "g", "h"),
            Animal(4, "a", "b", "c", "d", "e", "f", "g", "h")
        )

        val data = AnimalResult(ResultAnimal(0,
            0,
            0,
            animals,
            "a"))

        areaViewModel.animalData = data
        areaViewModel.putToItemList()

        val predicate: (Animal) -> Boolean = { it.aLocation == areaViewModel.area.eName }
        assertThat(areaViewModel.animalList.getOrAwaitValue().all(predicate)).isTrue()
        assertThat(areaViewModel.animalList.getOrAwaitValue()).isEqualTo(animals.filter { it.aLocation == areaViewModel.area.eName })
    }

    @Test
    fun navigateToAnimal_setsNavigateToAnimalLiveData() {

        val animal = Animal(1, "a", "b", "c", "d", "e", "f", "g", "h")

        areaViewModel.navigateToAnimalPage(animal)

        assertThat(areaViewModel.navigateToAnimal.getOrAwaitValue()).isEqualTo(animal)
    }
}