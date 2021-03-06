package com.example.gegbo.filxsterapp.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gegbo.filxsterapp.R;
import com.example.gegbo.filxsterapp.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by gegbo on 6/15/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    // View lookup cache
    public static class ViewHolder {
        @BindView(R.id.tvTitle) TextView tvTitle;
        @BindView(R.id.tvOverview) TextView tvOverview;
        @BindView(R.id.ivMovieImage) ImageView ivImage;

        public ViewHolder(View convertView) {
            ButterKnife.bind(this, convertView);
        }
    }


    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1,movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the data item for position
        Movie movie = getItem(position);


        //check to see if existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie,parent, false);
            viewHolder = new ViewHolder(convertView);

            //clear out image from convertView
            viewHolder.ivImage.setImageResource(0);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //populate data
        viewHolder.tvTitle.setText(movie.getOriginalTitle());
        viewHolder.tvOverview.setText(movie.getOverview());

        boolean isLandscape = getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if(isLandscape) {
            //Picasso.with(getContext()).load(movie.getBackdropPath()).into(viewHolder.ivImage);
            Picasso.with(getContext()).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(10,10)).placeholder(R.drawable.placeholder).into(viewHolder.ivImage);
        }
        else {
            //Picasso.with(getContext()).load(movie.getPosterPath()).into(viewHolder.ivImage);
//            if(movie.getBackdropPath() != null) {
                Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(10,10)).placeholder(R.drawable.placeholder).error(R.drawable.image_not_available).into(viewHolder.ivImage);
            //}
        }

        //return the view
        return convertView;

    }
}
