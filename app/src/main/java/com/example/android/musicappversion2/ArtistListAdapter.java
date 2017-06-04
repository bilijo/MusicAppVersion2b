package com.example.android.musicappversion2;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dam on 29.05.2017.
 */
public class ArtistListAdapter extends ArrayAdapter<Artist>{

    private int mColorResourceId;

    public ArtistListAdapter(Activity context, List<Artist> item, int colorResourceId ) {
        super(context, 0, item);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.artist_params, parent, false);

        }

        // Get the {@link Artist} object located at this position in the list
        Artist currentArtistName = getItem(position);

        // Find the TextView in the artist_params.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.artist_name);

        // Get the version name from the current Artist object and
        // set this text on the name TextView
        nameTextView.setText(currentArtistName.getArtistName());


        // Find the ImageView in the artist_params.xmlml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);

        // Get the image resource ID from the current Artist object and
        // set the image to iconView
        iconView.setImageResource(currentArtistName.getImageResourceId());


        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        nameTextView.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
