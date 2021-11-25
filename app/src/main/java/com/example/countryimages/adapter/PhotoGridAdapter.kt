package com.example.countryimages.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.countryimages.databinding.GridViewItemBinding
import com.example.countryimages.model.DataCountry

class PhotoGridAdapter: ListAdapter<DataCountry,
        PhotoGridAdapter.ItemViewHolder>(DiffCallback) {

            class ItemViewHolder(var binding: GridViewItemBinding)
                :RecyclerView.ViewHolder(binding.root){
                fun bind(flagPhoto: DataCountry){
                    binding.data = flagPhoto
                    //update immediately
                    binding.executePendingBindings()
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
     return ItemViewHolder(GridViewItemBinding.inflate(
         LayoutInflater.from(parent.context)
     ))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val flagsPhoto = getItem(position)
        holder.bind(flagsPhoto)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<DataCountry>(){
        override fun areItemsTheSame(oldItem: DataCountry, newItem: DataCountry): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: DataCountry, newItem: DataCountry): Boolean {
            return oldItem.flag == newItem.flag

        }

    }



}