package com.scujcc.moviepost;

import android.content.Intent;
import android.media.tv.TvContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;



public class MainActivity extends AppCompatActivity {
    private RecyclerView movieList;
    private MovieListAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieList = findViewById(R.id.movieList);
        movieAdapter = new MovieListAdapter();
        movieList.setLayoutManager(new LinearLayoutManager(this));
        movieList.setAdapter(movieAdapter);

    }
}
