package com.example.tp_movies;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp_movies.pojo.Genre;
import com.example.tp_movies.pojo.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private final List<Movie> mMovies;
    private final List<Genre> mGenres;

    public MovieAdapter(List<Movie> movies, List<Genre> genres){
        mMovies = movies;
        mGenres = genres;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View movieView = inflater.inflate(R.layout.item_movie, parent, false);

        return new ViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = mMovies.get(position);
        ImageView imageView = holder.movieImg;
        Picasso.get().load("https://image.tmdb.org/t/p/original"+movie.getPoster_path()).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MovieDetailsActivity.class);
                intent.putExtra("movie", movie);
                intent.putExtra("genres", getGenreById(movie.getGenre_ids(), mGenres));
                view.getContext().startActivity(intent);
            }

            public ArrayList<String> getGenreById(List<Integer> ids, List<Genre> genres) {
                ArrayList<String> genresText = new ArrayList<>();
                for (int n:
                     ids) {
                    for (Genre gn:
                         genres) {
                        if(n == gn.getId()) {
                            genresText.add(gn.getName());
                        }
                    }
                }
                return genresText;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView movieImg;

        public ViewHolder(View itemView){
            super(itemView);
            movieImg = (ImageView) itemView.findViewById(R.id.movie_detail_img);
        }
    }
}
