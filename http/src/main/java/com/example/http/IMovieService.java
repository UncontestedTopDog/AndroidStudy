package com.example.http;

import com.example.http.data.MovieData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface IMovieService {
    @GET("LocationMovies.api")
    Observable<MovieData> getData(
            @Query("locationId") int locaionId
    );
}
