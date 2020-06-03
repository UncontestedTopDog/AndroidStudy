package com.example.androidstudy.http.views;

import android.view.View;
import android.widget.TextView;

import com.edu.baserecyclerview.HeadViewHolder;
import com.example.androidstudy.R;

import androidx.annotation.NonNull;

public class MovieHead extends HeadViewHolder {
    public TextView headView;
    public MovieHead(@NonNull View itemView) {
        super(itemView);
        headView = itemView.findViewById(R.id.head_view);
    }
}
