package com.example.android.tourguide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.data.Attraction;

import java.util.List;

/**
 * Provides views for the list of attractions in the {@link android.widget.ListView}.
 */

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    public AttractionAdapter(@NonNull Context context, @NonNull List<Attraction> attractions) {
        super(context, 0, attractions);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_list_item, parent, false);
        }

        ImageView attractionImage = convertView.findViewById(R.id.attraction_image);
        TextView attractionName = convertView.findViewById(R.id.attraction_name);
        TextView attractionAddress = convertView.findViewById(R.id.attraction_address);

        Attraction attraction = getItem(position);
        attractionImage.setImageResource(attraction.getImageResourceId());
        attractionName.setText(attraction.getName());
        attractionAddress.setText(attraction.getAddress());

        return convertView;
    }
}
