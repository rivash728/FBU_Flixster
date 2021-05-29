package com.example.flixer.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double rating;
    String playsymbolPath;
    int movieId;

    // empty constructor needed by the Parceler library
    public Movie() {}

    public Movie(JSONObject jsonObject) throws JSONException {

        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        playsymbolPath = "https://www.freepnglogos.com/uploads/play-button-png/index-media-cover-art-play-button-overlay-5.png";
        movieId = jsonObject.getInt("id");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {

        List<Movie> movies = new ArrayList<>();

        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }

        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w780/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating(){
        return rating;
    }

    public String getplaysymbolPath(){return playsymbolPath;}

    public int getMovieId(){return movieId;}
}
