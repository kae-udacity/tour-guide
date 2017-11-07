package com.example.android.tourguide.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.android.tourguide.R;
import com.example.android.tourguide.data.Attraction;
import com.example.android.tourguide.databinding.ActivityAttractionBinding;

public class AttractionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAttractionBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_attraction);

        Attraction attraction = getIntent().getParcelableExtra(getString(R.string.attraction));

        binding.attractionImage.setImageResource(attraction.getImageResourceId());
        binding.attractionName.setText(attraction.getName());
        binding.attractionAddress.setText(attraction.getAddress());

        if (attraction.getOpeningHours() != null) {
            String openingHours = getString(R.string.opening_hours) + attraction.getOpeningHours();
            binding.attractionOpeningHours.setText(openingHours);
        } else {
            binding.attractionOpeningHours.setVisibility(View.INVISIBLE);
        }
    }
}
