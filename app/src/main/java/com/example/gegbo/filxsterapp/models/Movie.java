package com.example.gegbo.filxsterapp.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by gegbo on 6/15/16.
 */
public class Movie {
    String posterPath;
    String originalTitle;
    String overview;
    String backdropPath;
    Float voteCount;
    Double popularity;
    String releaseDate;

    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.voteCount = BigDecimal.valueOf(jsonObject.getDouble("vote_average")).floatValue();
        this.popularity = jsonObject.getDouble("popularity");
        this.releaseDate = jsonObject.getString("release_date");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();

        for(int i = 0; i<array.length();i++) {
            try {
                results.add(new Movie(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return results;
    }

    public String getPosterPath() {

        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }

    public float getVoteCount() {
        return voteCount;
    }

    public Double getPopularity() {
        return popularity;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
