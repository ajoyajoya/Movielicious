package com.ajoyajoya.movielicious;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataMovieName;
    private String[] dataMovieRate;
    private String[] dataMovieCat;
    private String[] dataMovieDesc;
    private TypedArray dataMoviePoster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list_movie);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(MainActivity.this, movies.get(position).getMovieName(), Toast.LENGTH_SHORT).show();

                Movie movie = new Movie();
                movie.setMovieName(movies.get(position).getMovieName());
                movie.setMovieRated(movies.get(position).getMovieRated());
                movie.setMovieCategory(movies.get(position).getMovieCategory());
                movie.setMovieDesc(movies.get(position).getMovieDesc());
                movie.setMoviePoster(movies.get(position).getMoviePoster());

                Intent moveIntent = new Intent(MainActivity.this, DetailMovie.class);
                moveIntent.putExtra(DetailMovie.EXTRA_MOVIE, movie);
                startActivity(moveIntent);

            }
        });
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataMovieName.length; i++) {
            Movie movie = new Movie();
            movie.setMoviePoster(dataMoviePoster.getResourceId(i, -1));
            movie.setMovieName(dataMovieName[i]);
            movie.setMovieRated(dataMovieRate[i]);
            movie.setMovieCategory(dataMovieCat[i]);
            movie.setMovieDesc(dataMovieDesc[i]);

            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        dataMovieName = getResources().getStringArray(R.array.data_movie_name);
        dataMovieRate = getResources().getStringArray(R.array.data_movie_rating);
        dataMovieCat = getResources().getStringArray(R.array.data_movie_category);
        dataMovieDesc = getResources().getStringArray(R.array.data_movie_desc);
        dataMoviePoster = getResources().obtainTypedArray(R.array.data_movie_poster);

    }
}
