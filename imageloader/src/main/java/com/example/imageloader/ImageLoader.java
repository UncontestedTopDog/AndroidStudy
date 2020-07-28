package com.example.imageloader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.annotation.DrawableRes;

public class ImageLoader {
    public static void load(Context context, String url, ImageView imageView,
                            @DrawableRes int resourceId) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .placeholder(resourceId)
                .into(imageView);
    }
}
