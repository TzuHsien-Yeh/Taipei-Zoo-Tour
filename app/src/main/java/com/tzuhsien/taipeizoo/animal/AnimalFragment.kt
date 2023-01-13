package com.tzuhsien.taipeizoo.animal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tzuhsien.taipeizoo.ZooApplication
import com.tzuhsien.taipeizoo.databinding.FragmentAnimalBinding

class AnimalFragment : Fragment() {

    private lateinit var binding: FragmentAnimalBinding

    private lateinit var viewModel: AnimalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAnimalBinding.inflate(layoutInflater)

        // Gets zooRepository from the instance of AppContainer in Application
        val appContainer = (requireContext().applicationContext as ZooApplication).container
        viewModel = AnimalViewModel(appContainer.zooRepository)

        return binding.root
    }

}