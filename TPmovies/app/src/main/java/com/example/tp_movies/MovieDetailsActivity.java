package com.example.tp_movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tp_movies.pojo.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieDetailsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView overview, releaseDate, genre_text;
    ArrayList<String> genres;
    Movie movie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        imageView = (ImageView) findViewById(R.id.movie_detail_img);
        overview = (TextView) findViewById(R.id.text_overview);
        releaseDate = (TextView) findViewById(R.id.text_release_date);
        genre_text = (TextView) findViewById(R.id.text_genre);
        Intent intent = getIntent();
        movie = (Movie) intent.getSerializableExtra("movie");
        genres = intent.getStringArrayListExtra("genres");
        Picasso.get().load("https://image.tmdb.org/t/p/original"+movie.getBackdrop_path()).into(imageView);
        overview.setText(movie.getOverview());
        this.setTitle(movie.getTitle());
        releaseDate.setText(movie.getRelease_date());
        String gn = new String("");
        for (String str:
             genres) {
            gn += str + "   ";
        }
        genre_text.setText(gn);

    }
}