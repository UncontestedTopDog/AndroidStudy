package com.example.androidstudy.http.views;

import android.view.View;
import android.widget.TextView;

import com.edu.baserecyclerview.FootViewHolder;
import com.example.androidstudy.R;

import androidx.annotation.NonNull;

public class MovieFoot extends FootViewHolder {
    public TextView footerView;
    public MovieFoot(@NonNull View itemView) {
        super(itemView);
        footerView = itemView.findViewById(R.id.footer_view);
    }
}
