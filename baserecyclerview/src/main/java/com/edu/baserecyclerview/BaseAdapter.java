package com.edu.baserecyclerview;

import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BaseAdapter<T> extends RecyclerView.Adapter {

    protected final static int TYPE_CONTENT = 0;
    protected final static int TYPE_FOOTER = 1;
    protected final static int TYPE_HEADER = 2;
    protected List<T> listData = new ArrayList<>();

    private RecyclerView.ViewHolder hvh;
    private RecyclerView.ViewHolder fvh;

    public BaseAdapter() {
    }

    public BaseAdapter(RecyclerView.ViewHolder hvh, RecyclerView.ViewHolder fvh) {
        this.hvh = hvh;
        this.fvh = fvh;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            return hvh;
        } else if (viewType == TYPE_FOOTER) {
            return fvh;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        int size = listData.size();
        if (hvh != null) {
            size++;
        }
        if (fvh != null) {
            size++;
        }
        return size;
    }

    @Override
    public int getItemViewType(int position) {
        if (hvh != null && fvh != null) {
            if (position == listData.size() + 1) {
                return TYPE_FOOTER;
            } else if (position == 0) {
                return TYPE_HEADER;
            }
            return TYPE_CONTENT;
        } else if (hvh != null) {
            if (position == 0) {
                return TYPE_HEADER;
            } else {
                return TYPE_CONTENT;
            }
        } else if (fvh != null) {
            if (position == listData.size()) {
                return TYPE_FOOTER;
            }
            return TYPE_CONTENT;
        } else {
            return TYPE_CONTENT;
        }
    }

    public void addData(List<T> datas) {
        this.listData.addAll(datas);
    }

    public void bindData(List<T> datas) {
        this.listData = datas;
    }
}
