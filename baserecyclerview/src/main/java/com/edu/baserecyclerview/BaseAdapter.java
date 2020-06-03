package com.edu.baserecyclerview;

import android.view.LayoutInflater;
import android.view.View;
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

    private HeadViewHolder hvh;
    private FootViewHolder fvh;
    private boolean needHeader;
    private boolean needFooter;

    public BaseAdapter(
            boolean needHeader,
            boolean needFooter) {
        this.needHeader = needHeader;
        this.needFooter  = needFooter;
    }

    public void initHFVH(HeadViewHolder hvh,
                         FootViewHolder fvh) {
        this.hvh = hvh;
        this.fvh = fvh;
    }

    public void setHVH(HeadViewHolder hvh) {
        this.hvh = hvh;
    }

    public void setFVH(FootViewHolder fvh) {
        this.fvh = fvh;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            if (hvh == null) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout,
                        parent, false);
                return new HeadViewHolder(view);
            }
            return hvh;
        } else if (viewType == TYPE_FOOTER) {
            if (fvh == null) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_layout,
                        parent, false);
                return new FootViewHolder(view);
            }
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
        if (needHeader) {
            size++;
        }
        if (needFooter) {
            size++;
        }
        return size;
    }

    @Override
    public int getItemViewType(int position) {
        if (needHeader && needFooter) {
            if (position == listData.size() + 1) {
                return TYPE_FOOTER;
            } else if (position == 0) {
                return TYPE_HEADER;
            }
            return TYPE_CONTENT;
        } else if (needHeader) {
            if (position == 0) {
                return TYPE_HEADER;
            } else {
                return TYPE_CONTENT;
            }
        } else if (needFooter) {
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
