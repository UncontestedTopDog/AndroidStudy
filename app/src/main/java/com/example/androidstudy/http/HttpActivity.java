package com.example.androidstudy.http;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.edu.baserecyclerview.OnLoadMoreListener;
import com.example.androidstudy.R;
import com.example.androidstudy.databinding.ActivityHttpBinding;
import com.example.androidstudy.http.viewmodel.MovieViewModel;
import com.example.androidstudy.http.viewmodel.MovieViewModelV2;
import com.example.androidstudy.http.views.IRefresh;
import com.example.androidstudy.http.views.MovieList;
import com.example.http.MovieManager;
import com.example.http.data.MovieData;

public class HttpActivity extends AppCompatActivity {

    // private ActivityHttpBinding httpBinding;
    private MovieViewModelV2 movieViewModel;
    private MovieList movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http2);
        // httpBinding = DataBindingUtil.setContentView(this,R.layout.activity_http2);
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModelV2.class);
        // httpBinding.movieView.setOnRefresh(this);
        movieList = findViewById(R.id.movie_list);
        movieList.addOnScrollListener(new OnLoadMoreListener() {
            @Override
            protected void onLoading(int countItem, int lastItem) {
                movieViewModel.loadData(298);
            }
        });
        movieViewModel.movieDataLiveData.observe(this, new Observer<MovieData>() {
            @Override
            public void onChanged(MovieData movieData) {
                Log.i("AAAAA","!!!!!!!"+movieData.toString());
                movieList.bindData(movieData.getMs());
            }
        });

        // httpBinding.getData.setOnClickListener(v->{
            movieViewModel.loadData(290);
        // });
    }
}
