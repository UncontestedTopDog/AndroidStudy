package com.example.androidstudy.mvvm.viewmodel;

import com.example.androidstudy.mvvm.repository.MovieRepository;
import com.example.http.data.MovieData;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MovieViewModel extends ViewModel {
    public MutableLiveData<MovieData> movieDataLiveData;

    public MovieViewModel() {
        movieDataLiveData = new MutableLiveData<>();
    }

    public void loadMovie(int location) {
        MovieRepository.getInstance().loadMovie(location)
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
