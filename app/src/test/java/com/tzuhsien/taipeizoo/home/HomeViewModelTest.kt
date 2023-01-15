package com.tzuhsien.taipeizoo.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.tzuhsien.taipeizoo.MainCoroutineRule
import com.tzuhsien.taipeizoo.data.model.Area
import com.tzuhsien.taipeizoo.data.model.AreaResult
import com.tzuhsien.taipeizoo.data.source.FakeZooRepository
import com.tzuhsien.taipeizoo.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {
    // Subject under test
    private lateinit var homeViewModel: HomeViewModel

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setupViewModel() {
        homeViewModel = HomeViewModel(FakeZooRepository())
    }

    @Test
    fun putToItemList_setsAreaListLiveData() {

        val areas = listOf(Area(0, "a", "b", "c", "d", "e"))

        val data = AreaResult(com.tzuhsien.taipeizoo.data.model.Result(0,
            0,
            0,
            areas,
            "a"))

        homeViewModel.putToItemList(data)

        assertThat(homeViewModel.areaList.getOrAwaitValue()).isEqualTo(areas)
    }

    @Test
    fun navigateToAreaPage_setsNavigateToAreaLiveData() {

        val area = Area(1, "a", "b", "c", "d", "e")

        homeViewModel.navigateToAreaPage(area)

        assertThat(homeViewModel.navigateToArea.getOrAwaitValue()).isEqualTo(area)
    }
}