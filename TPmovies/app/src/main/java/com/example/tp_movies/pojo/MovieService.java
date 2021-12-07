package com.example.tp_movies.pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieService {
    public static final String apiURL = "https://api.themoviedb.org/3/";

    public static final String apiKey = "caaad37e83d36ebf964438063af88a31";

    @GET("movie/popular?api_key="+apiKey+"&language=en-US&page=1")
    Call<MoviesList> listMovies();

     @GET("movie/upcoming?api_key="+apiKey+"&language=en-US&page=1")
     Call<MoviesList> upcomingMovies();

    @GET("genre/movie/list?api_key="+apiKey+"&language=en-US")
    Call<GenreList> genreList();



}
