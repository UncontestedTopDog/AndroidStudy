package com.example.androidstudy.http.views;

import android.view.View;
import android.widget.TextView;

import com.example.androidstudy.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieHeaderVH extends RecyclerView.ViewHolder {
    public TextView headView;

    public MovieHeaderVH(@NonNull View itemView) {
        super(itemView);
        headView = itemView.findViewById(R.id.head_view);
    }
}
