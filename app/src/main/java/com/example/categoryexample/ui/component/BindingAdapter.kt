package com.example.categoryexample.ui.component

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition


@BindingAdapter("android:textStyle")
fun setTextStyle(textView: TextView, style: String) {
    when (style) {
        "bold" -> textView.setTypeface(null, Typeface.BOLD)
        "italic" -> textView.setTypeface(null, Typeface.ITALIC)
        "bold_italic" -> textView.setTypeface(null, Typeface.BOLD_ITALIC)
        else -> textView.setTypeface(null, Typeface.NORMAL)
    }
}

@BindingAdapter("android:background")
fun setBackgroundImageUrl(view: View, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    view.background = resource
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    // Xử lý khi ảnh bị clear (nếu cần)
                }
            })
    }
}


@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .into(view)
    }
}


@BindingAdapter("fontFamilyResource")
fun setFontFamily(textView: TextView, fontResId: Int) {
    val typeface = ResourcesCompat.getFont(textView.context, fontResId)
    textView.typeface = typeface
}