package com.example.androidstudy.http.views;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.androidstudy.R;
import com.example.http.data.Ms;
import com.example.imageloader.ImageLoader;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    List<Ms> movieDetails;

    private Context context;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.movie_detail_view, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.i("AAAAA", movieDetails.get(position).getImg());
        Glide.with(context)
                .load(movieDetails.get(position).getImg())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return movieDetails.size();
    }

    public void bindData(List<Ms> movieDatas) {
        Log.i("AAAAA","!!!!!!!"+movieDatas.toString());
        this.movieDetails = movieDatas;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
}
