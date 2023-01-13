package com.tzuhsien.taipeizoo.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tzuhsien.taipeizoo.R
import com.tzuhsien.taipeizoo.ZooApplication
import com.tzuhsien.taipeizoo.area.AreaViewModel
import com.tzuhsien.taipeizoo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        // Gets zooRepository from the instance of AppContainer in Application
        val appContainer = (requireContext().applicationContext as ZooApplication).container
        viewModel = HomeViewModel(appContainer.zooRepository)

        return binding.root
    }

}