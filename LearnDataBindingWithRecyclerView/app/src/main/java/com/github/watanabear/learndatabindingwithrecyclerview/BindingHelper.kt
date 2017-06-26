package com.github.watanabear.learndatabindingwithrecyclerview

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by ryo on 2017/06/23.
 */

@BindingAdapter("bind:imageUrl")
fun ImageView.setImageUrl(url: String) {
    Picasso.with(context).load(url).into(this)
}