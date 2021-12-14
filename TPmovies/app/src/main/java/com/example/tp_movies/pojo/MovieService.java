package com.example.tp_movies.pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {
    public static final String apiURL = "https://api.themoviedb.org/3/";

    public static final String apiKey = "caaad37e83d36ebf964438063af88a31";

    @GET("movie/popular?api_key="+apiKey+"&language=en-US")
    Call<MoviesList> listMovies(@Query("page") String page);

     @GET("movie/upcoming?api_key="+apiKey+"&language=en-US")
     Call<MoviesList> upcomingMovies(@Query("page") String page);

    @GET("genre/movie/list?api_key="+apiKey+"&language=en-US")
    Call<GenreList> genreList();

    @GET("search/movie?api_key="+apiKey+"&language=en-US")
    Call<MoviesList> searchMovies(@Path("query") String query);
}
