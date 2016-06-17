package com.example.gegbo.filxsterapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by gegbo on 6/16/16.
 */
public class DetailMovieActivity extends AppCompatActivity {

    @BindView(R.id.ivBackgroundImage) ImageView ivPosterView;
    @BindView(R.id.rbRating) RatingBar ratingBar;
    @BindView(R.id.tvSummary) TextView overview;
    @BindView(R.id.tvTitle) TextView title;
    @BindView(R.id.tvPopularity) TextView popularity;
    @BindView(R.id.tvReleaseDate) TextView releaseDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String url = extras.getString("poster_path");
            Picasso.with(this).load(url).fit().transform(new RoundedCornersTransformation(10,10)).into(ivPosterView);

            Float number = extras.getFloat("vote_count");
            ratingBar.setNumStars(5);
            ratingBar.setRating((number/2));

            String summary = extras.getString("overview");
            overview.setText(summary);

            String name = extras.getString("title");
            title.setText(name);

            Double popular = extras.getDouble("popularity");
            popularity.setText((number*10)+"%");

            String release = extras.getString("release_date");
            releaseDate.setText(release);
        }
    }
}
