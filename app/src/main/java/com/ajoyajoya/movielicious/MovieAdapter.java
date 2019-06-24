package com.ajoyajoya.movielicious;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class MovieAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Movie> movies;


    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parentViewGroup) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_movie, parentViewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(convertView);
        Movie movie = (Movie) getItem(position);
        viewHolder.bind(movie);
        return convertView;
    }

    private class ViewHolder {
        private final TextView txtMovieName;
        private final TextView txtMovieRating;
        private final TextView txtMovieDescription;
        private final TextView txtMovieCategory;
        private final ImageView imgMoviePoster;
        ViewHolder(View view) {
            txtMovieName = view.findViewById(R.id.txt_movie_name);
            txtMovieRating = view.findViewById(R.id.txt_movie_rate);
            txtMovieCategory = view.findViewById(R.id.txt_movie_cat);
            txtMovieDescription = view.findViewById(R.id.txt_movie_desc);
            imgMoviePoster = view.findViewById(R.id.img_poster_movie);
        }
        void bind(Movie movie) {
            txtMovieName.setText(movie.getMovieName());
            txtMovieRating.setText(movie.getMovieRated());
            txtMovieCategory.setText(movie.getMovieCategory());
            txtMovieDescription.setText(movie.getMovieDesc());
            imgMoviePoster.setImageResource(movie.getMoviePoster());


            float backgroundRating = Float.parseFloat(movie.getMovieRated());

            if (backgroundRating>=8.0){
                txtMovieRating.setBackgroundColor(Color.parseColor("#3498db"));
            } else if (backgroundRating>=7.0){
                txtMovieRating.setBackgroundColor(Color.parseColor("#2ecc71"));
            } else if (backgroundRating>=6.0){
                txtMovieRating.setBackgroundColor(Color.parseColor("#f1c40f"));
            } else if (backgroundRating>=5.0){
                txtMovieRating.setBackgroundColor(Color.parseColor("#e67e22"));
            } else {
                txtMovieRating.setBackgroundColor(Color.parseColor("#e74c3c"));
            }
        }
    }
}
