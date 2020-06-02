package com.edu.baserecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BaseAdapter<T,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter {

    protected final static int TYPE_CONTENT = 0;
    protected final static int TYPE_FOOTER = 1;
    protected List<T> listData;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_layout,
                    parent,false);
            return new FootViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // if (getItemViewType(position) == TYPE_FOOTER) {
        //
        // } else {
        //     VH viewHolder = (VH) holder;
        // }
    }

    @Override
    public int getItemCount() {
        return listData.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == listData.size()) {
            return TYPE_FOOTER;
        }
        return  TYPE_CONTENT;
    }
}
