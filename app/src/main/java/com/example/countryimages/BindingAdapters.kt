package com.example.countryimages

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.countryimages.adapter.PhotoGridAdapter
import com.example.countryimages.model.DataCountry


@BindingAdapter("imageUrl")
fun ImageView.bindImage( imageUrl: String?) {
    imageUrl?.let {
        val imgUri = imageUrl.toUri().buildUpon().scheme("https").build()
        this.load(imgUri){
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,data: List<DataCountry>?){
    val adapter= recyclerView.adapter as PhotoGridAdapter
    //this tell the RecyclerView new list is available
    adapter.submitList(data)
}

