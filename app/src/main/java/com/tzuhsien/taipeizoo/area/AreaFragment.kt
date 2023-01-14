package com.tzuhsien.taipeizoo.area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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

        (activity as AppCompatActivity).supportActionBar?.title = viewModel.area.eName
//        val act = activity as AppCompatActivity?
//        if (act!!.supportActionBar != null) {
//            val toolbar: Toolbar = act!!.supportActionBar!!.customView as Toolbar
//        }
        return binding.root
    }

}