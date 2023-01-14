package com.tzuhsien.taipeizoo.area

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tzuhsien.taipeizoo.data.model.Animal
import com.tzuhsien.taipeizoo.databinding.ItemAnimalBinding
import com.tzuhsien.taipeizoo.ext.loadImage

class AnimalAdapter(
    private val uiState: AreaUiState
) : ListAdapter<Animal, AnimalAdapter.AnimalViewHolder> (DiffCallback) {

    class AnimalViewHolder(private val binding: ItemAnimalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animal: Animal) {
            binding.animalImage.loadImage(animal.aPic01Url)
            binding.txtAnimalName.text = animal.aNameCh
            binding.txtAnimalAlsoKnown.text = animal.aAlsoKnown
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Animal>() {
        override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem.aNameCh == newItem.aNameCh &&
                    oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder((ItemAnimalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)))
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            uiState.onClick(item)
        }
        holder.bind(item)
    }
}