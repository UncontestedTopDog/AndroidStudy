package com.example.androidstudy.http;

import android.os.Bundle;

import com.edu.baserecyclerview.OnLoadMoreListener;
import com.example.androidstudy.R;
import com.example.androidstudy.databinding.ActivityHttpBinding;
import com.example.androidstudy.http.viewmodel.MovieViewModelV2;
import com.example.androidstudy.http.views.IRefresh;
import com.example.http.data.MovieData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class HttpActivity extends AppCompatActivity implements IRefresh {

    private ActivityHttpBinding httpBinding;
    private MovieViewModelV2 movieViewModel;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        httpBinding = DataBindingUtil.setContentView(this, R.layout.activity_http);
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModelV2.class);
        httpBinding.movieView.setOnRefresh(this);
        httpBinding.movieView.addOnScrollListener(new OnLoadMoreListener() {
            @Override
            protected void onLoading(int countItem, int lastItem) {
                i++;
                movieViewModel.addData(i);
            }
        });
        movieViewModel.addData.observe(this, new Observer<MovieData>() {
            @Override
            public void onChanged(MovieData movieData) {
                if (movieData.getMs().size() != 0) {
                    httpBinding.movieView.addData(movieData.getMs());
                    return;
                }
                i++;
                movieViewModel.addData(i);
            }
        });

        movieViewModel.refreshData.observe(this, new Observer<MovieData>() {
            @Override
            public void onChanged(MovieData movieData) {
                if (movieData.getMs().size() != 0) {
                    httpBinding.movieView.bindData(movieData.getMs());
                    return;
                }
                i++;
                movieViewModel.addData(i);
            }
        });

        movieViewModel.refreshData(i);
    }

    @Override
    public void onRefresh() {
        i = 0;
        movieViewModel.refreshData(i);
    }
}
