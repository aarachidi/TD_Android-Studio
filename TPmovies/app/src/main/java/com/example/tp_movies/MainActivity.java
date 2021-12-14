package com.example.tp_movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.tp_movies.pojo.Genre;
import com.example.tp_movies.pojo.GenreList;
import com.example.tp_movies.pojo.Movie;
import com.example.tp_movies.pojo.MovieService;
import com.example.tp_movies.pojo.MoviesList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Movie> popularMovies, upcomingMovies = new ArrayList<>();
    List<Genre> genreList = new ArrayList<>();
    MovieService movieService;
    RecyclerView rvMovie;
    ImageButton popular_btn, new_btn;
    boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    int nextPage_popular = 2;
    int nextPage_upcoming = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMovie = (RecyclerView) findViewById(R.id.rvMovies);
        movieService = new Retrofit.Builder()
                .baseUrl(MovieService.apiURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieService.class);
        new_btn = (ImageButton) findViewById(R.id.imageButton_new);
        popular_btn = (ImageButton) findViewById(R.id.imageButton_popular);
        popular_btn.setEnabled(false);
        popular_btn.setColorFilter(Color.argb(255, 195, 195, 195));
        this.setTitle("Popular Movies");
        popularMovies = new ArrayList<>();
        upcomingMovies = new ArrayList<>();
        movieService.genreList().enqueue(new Callback<GenreList>() {
            @Override
            public void onResponse(Call<GenreList> call, Response<GenreList> response) {
                genreList = response.body().getGenres();
                //System.out.println("result2222222"+ genreList.toString());
            }

            @Override
            public void onFailure(Call<GenreList> call, Throwable t) {

            }
        });

        this.list_new(1);

        this.list_popular(1);



        new_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new_btn.setColorFilter(Color.argb(255, 195, 195, 195));
                popular_btn.setColorFilter(Color.argb(255, 255, 255, 255));
                popular_btn.setEnabled(true);
                new_btn.setEnabled(false);
                MovieAdapter adapter = new MovieAdapter(upcomingMovies, genreList);
                rvMovie.setAdapter(adapter);
                MainActivity.this.setTitle("Upcoming Movies");


            }
        });


        popular_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popular_btn.setEnabled(false);
                popular_btn.setColorFilter(Color.argb(255, 195, 195, 195));
                new_btn.setColorFilter(Color.argb(255, 255, 255, 255));
                new_btn.setEnabled(true);
                MovieAdapter adapter = new MovieAdapter(popularMovies, genreList);
                rvMovie.setAdapter(adapter);
                MainActivity.this.setTitle("Popular Movies");


            }
        });

        rvMovie.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                if(dy > 0) //check for scroll down
                {

                    visibleItemCount = rvMovie.getLayoutManager().getChildCount();
                    totalItemCount = rvMovie.getLayoutManager().getItemCount();
                    pastVisiblesItems = ((GridLayoutManager) rvMovie.getLayoutManager()).findFirstVisibleItemPosition();

                    if (loading)
                    {
                        if ( (visibleItemCount + pastVisiblesItems) >= totalItemCount)
                        {
                            if (new_btn.isEnabled())
                            {
                                MainActivity.this.list_popular(nextPage_popular);
                                nextPage_popular++;
                            }
                            loading = false;
                            Log.v(":::::::::::::::", "Last Item Wow ! "+ totalItemCount);
                            //Do pagination.. i.e. fetch new data
                        }
                    }
                }
            }
        });




    }

    void list_new(int page) {
        movieService.upcomingMovies(String.valueOf(page)).enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                upcomingMovies.addAll(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {

            }
        });
    }

    void list_popular(int page) {
        movieService.listMovies(String.valueOf(page)).enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                popularMovies.addAll(response.body().getResults());

                if(page ==1) {
                    MovieAdapter adapter = new MovieAdapter(popularMovies, genreList);

                    rvMovie.setAdapter(adapter);

                    rvMovie.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));

                    //rvMovie.scrollToPosition(10);
                }
                else {
                    MovieAdapter adapter = new MovieAdapter(popularMovies, genreList);
                    rvMovie.setAdapter(adapter);
                    rvMovie.scrollToPosition((page-1)*20);
                }

            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {

            }
        });
    }




}