package com.example.androidstudy.http.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.edu.baserecyclerview.OnLoadMoreListener;
import com.example.androidstudy.R;
import com.example.http.data.Ms;

import java.util.List;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MovieView extends RelativeLayout {

    MovieList movieList;
    SwipeRefreshLayout movieRefresh;
    IRefresh refresh;

    public MovieView(Context context) {
        this(context, null);
    }

    public MovieView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MovieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = inflate(context, R.layout.movie_view_layout, this);
        movieRefresh = view.findViewById(R.id.movie_refresh);
        movieList = view.findViewById(R.id.movie_list);
        movieRefresh.setRefreshing(false);
        movieRefresh.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light);

        movieRefresh.setProgressBackgroundColorSchemeResource(android.R.color.white);
        movieRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (refresh != null) {
                    refresh.onRefresh();
                }
            }
        });
    }

    public void setOnRefresh(IRefresh refresh) {
        this.refresh = refresh;
    }

    public void bindData(List<Ms> movieDetails) {
        movieRefresh.setRefreshing(false);
        movieList.bindData(movieDetails);
    }

    public void addData(List<Ms> movieDetails) {
        movieRefresh.setRefreshing(false);
        movieList.addData(movieDetails);
    }

    public void addOnScrollListener(OnLoadMoreListener listener) {
        movieList.addOnScrollListener(listener);
    }

}
