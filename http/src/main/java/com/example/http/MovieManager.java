package com.example.http;

import com.example.http.data.MovieData;

import rx.Observable;

public class MovieManager {
    private static MovieManager instance;

    private MovieManager() {
    }

    public static MovieManager getInstance() {
        if (instance == null) {
            synchronized (MovieManager.class) {
                if (instance == null) {
                    instance = new MovieManager();
                }
            }
        }

        return instance;
    }

    public Observable<MovieData> getData(int location) {
       return MovieService.getData(location);
    }
}
