package com.radish.evan.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public String movieStr;

    public DetailActivityFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        // The detail Activity called via intent.  Inspect the intent for movie data.
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            movieStr = intent.getStringExtra(Intent.EXTRA_TEXT);

            Picasso.with(DetailActivityFragment.this.getContext())
                    .load(movieStr)
                    .placeholder(R.drawable.loader)
                    .into((ImageView) rootView.findViewById(R.id.detail_imageView));
            //((GridView) rootView.findViewById(R.id.detail_imageView))

        }

        return rootView;
    }
}
