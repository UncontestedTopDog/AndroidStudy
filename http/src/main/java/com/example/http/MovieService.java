package com.example.http;

import com.example.http.data.MovieData;
import rx.Observable;

public class MovieService {
    public static Observable<MovieData> getData(int location) {
        return new RetrofitBuilder("https://api-m.mtime.cn/Showtime/").build(IMovieService.class).getData(location);
    }
}
