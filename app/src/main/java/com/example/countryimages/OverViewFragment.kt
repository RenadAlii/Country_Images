package com.example.countryimages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.countryimages.adapter.PhotoGridAdapter
import com.example.countryimages.databinding.FragmentOverViewBinding
import com.example.countryimages.databinding.GridViewItemBinding

import com.example.countryimages.model.CountryViewModel


class OverViewFragment : Fragment() {
    private val viewModel: CountryViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverViewBinding.inflate(inflater)
        //val binding = GridViewItemBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel
       binding.photosGrid.adapter = PhotoGridAdapter()
        return binding.root
    }
}
