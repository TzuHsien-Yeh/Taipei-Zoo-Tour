package com.tzuhsien.taipeizoo.animal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tzuhsien.taipeizoo.R
import com.tzuhsien.taipeizoo.ZooApplication
import com.tzuhsien.taipeizoo.databinding.FragmentAnimalBinding
import com.tzuhsien.taipeizoo.ext.loadImage

class AnimalFragment : Fragment() {

    private lateinit var binding: FragmentAnimalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAnimalBinding.inflate(layoutInflater)

        val animal = AnimalFragmentArgs.fromBundle(requireArguments()).animalKey

        // Set up toolbar with animal name
        (activity as AppCompatActivity).supportActionBar?.title = animal.aNameCh

        binding.imgAnimal.loadImage(animal.aPic01Url)
        binding.txtAnimalNameCh.text = animal.aNameCh
        binding.txtAnimalNameLatin.text = animal.aNameLatin
        binding.txtAnimalAlsoKnown.text = animal.aAlsoKnown
        binding.txtAnimalAlsoKnown.visibility = if (animal.aAlsoKnown.isEmpty()) View.GONE else View.VISIBLE
        binding.txtAlsoKnown.visibility = if (animal.aAlsoKnown.isEmpty()) View.GONE else View.VISIBLE
        binding.txtAnimalFeature.text = animal.aFeature
        binding.txtAnimalBehavior.text = animal.aBehavior
        binding.txtAnimalUpdate.text = getString(R.string.animal_update, animal.aUpdate)

        return binding.root
    }

}