package com.tzuhsien.taipeizoo.area

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.tzuhsien.taipeizoo.ZooApplication
import com.tzuhsien.taipeizoo.databinding.FragmentAreaBinding
import com.tzuhsien.taipeizoo.ext.loadImage


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

        // Set up toolbar with are name
        (activity as AppCompatActivity).supportActionBar?.title = viewModel.area.eName

        binding.imgArea.loadImage(viewModel.area.ePicUrl)
        binding.txtAreaInfo.text = viewModel.area.eInfo
        binding.txtAreaCategory.text = viewModel.area.eCategory
        binding.txtOpenInBrowser.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(viewModel.area.eUrl))
            startActivity(browserIntent)
        }

        val adapter = AnimalAdapter(uiState = viewModel.uiState)
        binding.recyclerViewAnimal.adapter = adapter
        viewModel.AnimalList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return binding.root
    }

}