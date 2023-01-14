package com.tzuhsien.taipeizoo.area

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat
import androidx.fragment.app.viewModels
import com.tzuhsien.taipeizoo.R
import com.tzuhsien.taipeizoo.ZooApplication
import com.tzuhsien.taipeizoo.databinding.FragmentAreaBinding

class AreaFragment : Fragment() {

    private lateinit var binding: FragmentAreaBinding

    private lateinit var viewModel: AreaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentAreaBinding.inflate(layoutInflater)

        // Gets zooRepository from the instance of AppContainer in Application
        val appContainer = (requireContext().applicationContext as ZooApplication).container
        viewModel = AreaViewModel(appContainer.zooRepository, AreaFragmentArgs.fromBundle(requireArguments()).areaKey)

        return binding.root
    }

}