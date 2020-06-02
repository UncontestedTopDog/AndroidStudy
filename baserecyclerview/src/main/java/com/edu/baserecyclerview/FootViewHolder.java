package com.edu.baserecyclerview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.RecyclerView;

public class FootViewHolder extends RecyclerView.ViewHolder {
    ContentLoadingProgressBar footerProgress;

    public FootViewHolder(@NonNull View itemView) {
        super(itemView);
        footerProgress = itemView.findViewById(R.id.footer_progress);
    }
}
