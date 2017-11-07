package com.example.android.tourguide.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.activity.AttractionActivity;
import com.example.android.tourguide.adapter.AttractionAdapter;
import com.example.android.tourguide.data.Attraction;
import com.example.android.tourguide.databinding.FragmentListBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} to display the list of restaurants.
 */

public class RestaurantsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);

        final ArrayList<Attraction> restaurants = new ArrayList<>();
        restaurants.add(new Attraction(getString(R.string.emma), getString(R.string.emma_address), getString(R.string.emma_opening_hours), R.drawable.restaurant));
        restaurants.add(new Attraction(getString(R.string.pizzarium), getString(R.string.pizzarium_address), getString(R.string.pizzarium_opening_hours), R.drawable.restaurant));
        restaurants.add(new Attraction(getString(R.string.neno), getString(R.string.neno_address), getString(R.string.neno_opening_hours), R.drawable.restaurant));
        restaurants.add(new Attraction(getString(R.string.life), getString(R.string.life_address), getString(R.string.life_opening_hours), R.drawable.restaurant));

        AttractionAdapter adapter = new AttractionAdapter(getContext(), restaurants);

        binding.list.setAdapter(adapter);
        binding.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Attraction attraction = restaurants.get(i);
                Intent intent = new Intent(getActivity(), AttractionActivity.class);
                intent.putExtra(getString(R.string.attraction), attraction);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}
