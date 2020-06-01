package com.example.androidstudy.http.viewmodel;

import android.app.Application;

import com.example.http.MovieManager;
import com.example.http.data.MovieData;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MovieViewModelV2 extends AndroidViewModel {
    public MutableLiveData<MovieData> movieDataLiveData;
    public MovieViewModelV2(@NonNull Application application) {
        super(application);
        movieDataLiveData = new MutableLiveData<>();
    }

    public void loadData() {
        MovieManager.getInstance().getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MovieData>() {
                    @Override
                    public void call(MovieData movieData) {
                        movieDataLiveData.setValue(movieData);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }


}
