package com.demo.marksupp.shared

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


class GenericBindingAdapter {

    companion object{
        @BindingAdapter(value = ["android:imageUrl", "android:placeholder"])
        @JvmStatic
        fun loadImageUrl(imageView: ImageView, imgUrl: String?, drawable: Drawable) {

            Glide.with(imageView.context)
                .load(imgUrl ?: drawable)
                .apply(
                    RequestOptions()
                        .placeholder(drawable)
                        .error(drawable)
                )
                .circleCrop()
                .into(imageView)
        }

        @BindingAdapter(value = ["android:imagePostUrl", "android:placeholder"])
        @JvmStatic
        fun loadPostImageUrl(imageView: ImageView, imgUrl: String?, drawable: Drawable) {
            Glide.with(imageView.context)
                .load(imgUrl)
                .apply(
                    RequestOptions()
                        .placeholder(drawable)
                        .error(drawable)
                )
                .transform( CenterInside(), RoundedCorners(20))
                .into(imageView)
        }
    }
}