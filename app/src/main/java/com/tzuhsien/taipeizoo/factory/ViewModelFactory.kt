//package com.tzuhsien.taipeizoo.factory
//
//import androidx.core.content.ContentProviderCompat.requireContext
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.tzuhsien.taipeizoo.ZooApplication
//import com.tzuhsien.taipeizoo.animal.AnimalViewModel
//import com.tzuhsien.taipeizoo.area.AreaViewModel
//import com.tzuhsien.taipeizoo.data.source.ZooRepository
//import com.tzuhsien.taipeizoo.home.HomeViewModel
//
//
//@Suppress("UNCHECKED_CAST")
//class ViewModelFactory(
//    private val zooRepository: ZooRepository,
//) : ViewModelProvider.Factory {
//
//    // Gets zooRepository from the instance of AppContainer in Application
//    val appContainer = (requireContext().applicationContext as ZooApplication).container
//
//    override fun <T : ViewModel> create(modelClass: Class<T>) =
//        with(modelClass) {
//            when {
//                isAssignableFrom(HomeViewModel::class.java) ->
//                    HomeViewModel(zooRepository)
//
//                isAssignableFrom(AreaViewModel::class.java) ->
//                    AreaViewModel(zooRepository)
//
//                isAssignableFrom(AnimalViewModel::class.java) ->
//                    AnimalViewModel(zooRepository)
//
//                else ->
//                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
//            }
//        } as T
//}