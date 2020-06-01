package com.example.http;

import com.example.http.data.MovieData;
import rx.Observable;

public class MovieService {
    public static Observable<MovieData> getData() {
        return new RetrofitBuilder("https://api-m.mtime.cn/Showtime/").build(IMovieService.class).getData(290);
    }
}
