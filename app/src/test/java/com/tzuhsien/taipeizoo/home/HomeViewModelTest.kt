package com.tzuhsien.taipeizoo.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.tzuhsien.taipeizoo.MainCoroutineRule
import com.tzuhsien.taipeizoo.data.Result
import com.tzuhsien.taipeizoo.data.model.Area
import com.tzuhsien.taipeizoo.data.model.AreaResult
import com.tzuhsien.taipeizoo.data.source.FakeZooRepository
import com.tzuhsien.taipeizoo.getOrAwaitValue
import com.tzuhsien.taipeizoo.network.LoadApiStatus
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import timber.log.Timber

@ExperimentalCoroutinesApi
class HomeViewModelTest {
    // Subject under test
    private lateinit var homeViewModel: HomeViewModel

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val fakeZooRepository = FakeZooRepository()

    @Before
    fun setupViewModel() {
        homeViewModel = HomeViewModel(fakeZooRepository)
    }

    @Test
    fun getAreaInfo_networkError_returnErrorMsg(){
        // Given the situation of network error
        fakeZooRepository.setShouldReturnNetworkError(true)

        homeViewModel.getAreaInfo()

        assertThat(homeViewModel.error.getOrAwaitValue()).isEqualTo("Error")
        assertThat(homeViewModel.status.getOrAwaitValue()).isEqualTo(LoadApiStatus.ERROR)
        assertThat(homeViewModel.areaData).isEqualTo(null)
    }

    @Test
    fun getAreaInfo_network_returnSuccess(){

        homeViewModel.getAreaInfo()

        assertThat(homeViewModel.error.getOrAwaitValue()).isEqualTo(null)
        assertThat(homeViewModel.status.getOrAwaitValue()).isNotEqualTo(LoadApiStatus.ERROR)
        assertThat(homeViewModel.areaData).isEqualTo(fakeZooRepository.areaResult)
    }

    @Test
    fun putToItemList_setsAreaListLiveData() {

        val areas = listOf(
            Area(0, "a", "b", "c", "d", "e")
        )

        val data = AreaResult(com.tzuhsien.taipeizoo.data.model.Result(0,
            0,
            0,
            areas,
            "a"))

        homeViewModel.areaData = data
        homeViewModel.putToItemList()

        assertThat(homeViewModel.areaList.getOrAwaitValue()).isNotEmpty()
    }

    @Test
    fun navigateToAreaPage_setsNavigateToAreaLiveData() {

        val area = Area(1, "a", "b", "c", "d", "e")

        homeViewModel.navigateToAreaPage(area)

        assertThat(homeViewModel.navigateToArea.getOrAwaitValue()).isEqualTo(area)
    }
}