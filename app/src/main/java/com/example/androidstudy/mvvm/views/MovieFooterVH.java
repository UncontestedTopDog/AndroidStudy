package com.example.androidstudy.mvvm.views;

import android.view.View;
import android.widget.TextView;

import com.example.androidstudy.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieFooterVH extends RecyclerView.ViewHolder {
    public TextView footerView;

    public MovieFooterVH(@NonNull View itemView) {
        super(itemView);
        footerView = itemView.findViewById(R.id.footer_view);
    }
}
