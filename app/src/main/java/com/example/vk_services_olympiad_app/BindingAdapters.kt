package com.example.vk_services_olympiad_app

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.vk_services_olympiad_app.model.Item
import com.example.vk_services_olympiad_app.view_model.ServicesViewModel

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Item>?) {
    Log.d("bindingDebug", "1");
    val adapter = recyclerView.adapter as ServicesCardsAdapter
    Log.d("bindingDebug", "2");
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri){
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("VkApiStatus")
fun bindStatus(statusImageView: ImageView, status: ServicesViewModel.VkApiStatus) {
    when (status) {
        ServicesViewModel.VkApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ServicesViewModel.VkApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        ServicesViewModel.VkApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }

}




