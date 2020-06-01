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

import com.example.androidstudy.R;
import com.example.androidstudy.databinding.ActivityHttpBinding;
import com.example.androidstudy.http.viewmodel.MovieViewModel;
import com.example.androidstudy.http.viewmodel.MovieViewModelV2;
import com.example.http.MovieManager;
import com.example.http.data.MovieData;

public class HttpActivity extends AppCompatActivity {

    private ActivityHttpBinding httpBinding;
    // private MovieViewModel movieViewModel;
    private MovieViewModelV2 movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        httpBinding = DataBindingUtil.setContentView(this,R.layout.activity_http);
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModelV2.class);
        movieViewModel.movieDataLiveData.observe(this, new Observer<MovieData>() {
            @Override
            public void onChanged(MovieData movieData) {
                httpBinding.result.setText(movieData.toString());
            }
        });

        // movieViewModel = new MovieViewModel();
        // movieViewModel.movieLiveData.observe(this, new Observer<MovieData>() {
        //     @Override
        //     public void onChanged(MovieData movieData) {
        //         httpBinding.result.setText(movieData.toString());
        //     }
        // });
        httpBinding.getData.setOnClickListener(v->{
            movieViewModel.loadData();
        });
    }
}
