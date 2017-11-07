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
 * A simple {@link Fragment} to display the list of parks.
 */

public class ParksFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);

        final ArrayList<Attraction> parks = new ArrayList<>();
        parks.add(new Attraction(getString(R.string.villa_borghese), getString(R.string.villa_borghese_address), R.drawable.park));
        parks.add(new Attraction(getString(R.string.park_caffarella), getString(R.string.park_caffarella_address), R.drawable.park));
        parks.add(new Attraction(getString(R.string.villa_doria_pamphili), getString(R.string.villa_doria_pamphili_address), R.drawable.park));
        parks.add(new Attraction(getString(R.string.rome_rose_garden), getString(R.string.rome_rose_garden_address), R.drawable.park));

        AttractionAdapter adapter = new AttractionAdapter(getContext(), parks);
        binding.list.setAdapter(adapter);

        binding.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Attraction attraction = parks.get(i);
                Intent intent = new Intent(getActivity(), AttractionActivity.class);
                intent.putExtra(getString(R.string.attraction), attraction);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}
