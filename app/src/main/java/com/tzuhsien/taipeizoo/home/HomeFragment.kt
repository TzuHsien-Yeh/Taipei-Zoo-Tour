package com.tzuhsien.taipeizoo.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.tzuhsien.taipeizoo.R
import com.tzuhsien.taipeizoo.ZooApplication
import com.tzuhsien.taipeizoo.area.AreaViewModel
import com.tzuhsien.taipeizoo.databinding.FragmentHomeBinding
import com.tzuhsien.taipeizoo.network.LoadApiStatus

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

        // RecyclerView
        val adapter = AreaAdapter(viewModel.uiState)
        binding.recyclerViewArea.adapter = adapter
        viewModel.AreaList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.navigateToArea.observe(viewLifecycleOwner) {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAreaFragment(it))
        }

        /** Loading status **/
        viewModel.status.observe(viewLifecycleOwner) {
            binding.imgLoader.visibility = if (it == LoadApiStatus.DONE) View.GONE else View.VISIBLE
        }

        return binding.root
    }

}