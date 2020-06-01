package com.example.androidstudy.http.repository;

import android.util.Log;

import com.example.http.MovieManager;
import com.example.http.data.MovieData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MovieDataRepository {
    private static MovieDataRepository instance;

    private MovieDataRepository() {
    }

    public static MovieDataRepository getInstance() {
        if (instance == null) {
            synchronized (MovieDataRepository.class) {
                if (instance == null) {
                    instance = new MovieDataRepository();
                }
            }
        }

        return instance;
    }
    public LiveData<MovieData> getMovieData() {
        final MutableLiveData<MovieData> data = new MutableLiveData<>();
        MovieManager.getInstance().getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MovieData>() {
                    @Override
                    public void call(MovieData movieData) {
                        data.setValue(movieData);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.i("AAAA",throwable.toString());
                    }
                });
        return data;
    }
}
