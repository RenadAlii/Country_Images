package com.example.countryimages

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest
import com.example.countryimages.adapter.PhotoGridAdapter
import com.example.countryimages.model.DataCountry
import com.example.countryimages.model.FlagApiStatus


@BindingAdapter("imageUrl")
fun ImageView.loadSvg(imageUri: String?) {
imageUri?.let{
    val imageLoader = ImageLoader.Builder(this.context)
        .componentRegistry { add(SvgDecoder(this@loadSvg.context)) }
        .build()

    this.load(uri = imageUri, imageLoader = imageLoader) {
        crossfade(true)
        placeholder(R.drawable.loading_animation)
        error(R.drawable.ic_broken_image)    }
}

}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,data: List<DataCountry>?){
    val adapter= recyclerView.adapter as PhotoGridAdapter
    //this tell the RecyclerView new list is available
    adapter.submitList(data)
}

@BindingAdapter("flagApiStatus")
fun bindStatus(statusImageView: ImageView,
               status: FlagApiStatus?) {
    when (status) {
        FlagApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        FlagApiStatus.ERROR ->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        FlagApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

