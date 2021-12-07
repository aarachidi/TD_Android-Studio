package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepoActivity extends AppCompatActivity {
    Intent intent;
    List<Repo> repositories = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);
        intent = getIntent();
        GithubService service = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);

        service.searchRepos(intent.getStringExtra("searchQ")).enqueue(new Callback<SearchRepo>() {
            @Override
            public void onResponse(Call<SearchRepo> call, Response<SearchRepo> response) {

                RecyclerView rvRepo = (RecyclerView) findViewById(R.id.rvContacts);

                System.out.println(response.body().getTotal_count());
                repositories = response.body().getItems();

                RepoAdapter adapter = new RepoAdapter(repositories);

                rvRepo.setAdapter(adapter);

                rvRepo.setLayoutManager(new LinearLayoutManager(RepoActivity.this));
            }

            @Override
            public void onFailure(Call<SearchRepo> call, Throwable t) {

            }
        });


    }
}