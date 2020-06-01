package com.example.androidstudy.http.viewmodel;

import android.util.Log;

import com.example.http.MovieManager;
import com.example.http.data.MovieData;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MovieViewModel extends ViewModel {

    public MutableLiveData<MovieData> movieLiveData = new MutableLiveData<>();

    public void loadData() {
        MovieManager.getInstance().getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MovieData>() {
                    @Override
                    public void call(MovieData movieData) {
                        Log.i("success: ",movieData.toString());
                        movieLiveData.setValue(movieData);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.i("fail: ",throwable.toString());
                    }
                });
    }

}
