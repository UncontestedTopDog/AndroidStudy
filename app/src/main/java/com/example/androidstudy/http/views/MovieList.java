package com.example.androidstudy.http.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.edu.baserecyclerview.DefaultVHBuilder;
import com.example.androidstudy.R;
import com.example.http.data.Ms;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MovieList extends RecyclerView {
    private MovieAdapter adapter;
    private Context context;
    public MovieList(@NonNull Context context) {
        this(context, null);
    }

    public MovieList(@NonNull Context context,
                     @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MovieList(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        setLayoutManager(layoutManager);
    }

    public void bindData(List<Ms> movieDetails) {
        if (adapter == null) {
            View headView = View.inflate(context, R.layout.movie_head_layout, null);
            MovieHeaderVH headVH =  new MovieHeaderVH(headView);
            View footView = View.inflate(context, R.layout.movie_foot_layout, null);
            MovieFooterVH footVH =  new MovieFooterVH(footView);
            adapter = new MovieAdapter(context,headVH, DefaultVHBuilder.buildFooter(context));
            setAdapter(adapter);
        }
        adapter.bindData(movieDetails);
        adapter.notifyDataSetChanged();
    }
    public void addData(List<Ms> movieDetails) {
        if (adapter == null) {
            View headView = View.inflate(context, R.layout.movie_head_layout, null);
            MovieHeaderVH headVH =  new MovieHeaderVH(headView);
            View footView = View.inflate(context, R.layout.movie_foot_layout, null);
            MovieFooterVH footVH =  new MovieFooterVH(footView);
            adapter = new MovieAdapter(context,headVH,footVH);
            setAdapter(adapter);
        }
        adapter.addData(movieDetails);
        adapter.notifyDataSetChanged();
    }
}
