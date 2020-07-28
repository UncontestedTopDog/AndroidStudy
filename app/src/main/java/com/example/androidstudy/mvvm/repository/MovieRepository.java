package com.example.androidstudy.mvvm.repository;

import com.example.http.MovieManager;
import com.example.http.data.MovieData;

import rx.Observable;

public class MovieRepository {

    private static MovieRepository instance;

    private MovieRepository() {
    }

    public static MovieRepository getInstance() {
        if (instance == null) {
            synchronized (MovieRepository.class) {
                if (instance == null) {
                    instance = new MovieRepository();
                }
            }
        }
        return instance;
    }

    public Observable<MovieData> loadMovie(int location) {
        return MovieManager.getInstance().getData(location);
    }

}
