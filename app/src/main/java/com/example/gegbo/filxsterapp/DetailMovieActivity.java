package com.example.gegbo.filxsterapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by gegbo on 6/16/16.
 */
public class DetailMovieActivity extends AppCompatActivity {

    ImageView ivPosterView;
    RatingBar ratingBar;
    TextView overview;
    TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie);

        //etEditItem = (EditText) findViewById(R.id.etEditItem);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String url = extras.getString("poster_path");
            Integer number = extras.getInt("vote_count");
            String summary = extras.getString("overview");
            String name = extras.getString("title");

            //etEditItem.setText(value);
            //position = number;
        }
    }
}
