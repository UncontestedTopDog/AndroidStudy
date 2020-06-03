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
    public MutableLiveData<MovieData> refreshData;
    public MutableLiveData<MovieData> addData;
    public MovieViewModelV2(@NonNull Application application) {
        super(application);
        refreshData = new MutableLiveData<>();
        addData = new MutableLiveData<>();
    }

    public void refreshData(int location) {
        MovieManager.getInstance().getData(location+290)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MovieData>() {
                    @Override
                    public void call(MovieData movieData) {
                        refreshData.setValue(movieData);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }

    public void addData(int location) {
        MovieManager.getInstance().getData(location+290)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MovieData>() {
                    @Override
                    public void call(MovieData movieData) {
                        addData.setValue(movieData);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }


}
