package com.example.androidstudy.http.views;

import android.content.Context;
import android.util.Log;
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

public class MovieAdapterV2 extends BaseAdapter<Ms, MovieAdapterV2.ViewHolder> {


    private Context context;

    public MovieAdapterV2(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder =  super.onCreateViewHolder(parent, viewType);
        if (viewHolder == null) {
            View view = View.inflate(parent.getContext(), R.layout.movie_detail_view, null);
            return new ViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_FOOTER) {

        } else {
            ViewHolder viewHolder = (ViewHolder) holder;
            Log.i("AAAAA", listData.get(position).getImg());
            Glide.with(context)
                    .load(listData.get(position).getImg())
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
        Log.i("AAAAA","!!!!!!!"+movieDatas.toString());
        this.listData = movieDatas;
    }
}
