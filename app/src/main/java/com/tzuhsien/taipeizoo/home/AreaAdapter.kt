package com.tzuhsien.taipeizoo.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tzuhsien.taipeizoo.data.model.Area
import com.tzuhsien.taipeizoo.databinding.ItemAreaBinding
import com.tzuhsien.taipeizoo.ext.loadImage
import com.tzuhsien.taipeizoo.home.AreaAdapter.AreaViewHolder

class AreaAdapter(
    private val uiState: HomeUiState
) : ListAdapter<Area, AreaViewHolder> (DiffCallback) {

    class AreaViewHolder(private val binding: ItemAreaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(area: Area) {
            binding.areaImage.loadImage(area.ePicUrl)
            binding.txtAreaName.text = area.eName
            binding.txtAreaInfo.text = area.eInfo
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Area>() {
        override fun areItemsTheSame(oldItem: Area, newItem: Area): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Area, newItem: Area): Boolean {
            return oldItem.eName == newItem.eName &&
                    oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaViewHolder {
        return AreaViewHolder((ItemAreaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)))
    }

    override fun onBindViewHolder(holder: AreaViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            uiState.onClick(item)
        }
        holder.bind(item)
    }
}