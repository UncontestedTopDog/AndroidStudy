package com.example.androidstudy.http.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.edu.baserecyclerview.BaseAdapter;
import com.example.androidstudy.R;
import com.example.http.data.Ms;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends BaseAdapter<Ms> {

    private Context context;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public MovieAdapter(Context context, RecyclerView.ViewHolder hvh, RecyclerView.ViewHolder fvh) {
        super(hvh, fvh);
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
        if (viewHolder == null) {
            View view = View.inflate(parent.getContext(), R.layout.movie_detail_view, null);
            return new ViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) {
            MovieHeaderVH headerVH = (MovieHeaderVH) holder;
            headerVH.headView.setText("电影的开始");
        } else if (getItemViewType(position) == TYPE_FOOTER) {
            // MovieFooterVH footerVH = (MovieFooterVH) holder;
            // footerVH.footerView.setText("继续加载更多");
        } else {
            ViewHolder viewHolder = (ViewHolder) holder;
            Glide.with(context)
                    .load(listData.get(position - 1).getImg())
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(viewHolder.image);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }

    public void bindData(List<Ms> movieDatas) {
        super.bindData(movieDatas);
    }
}
