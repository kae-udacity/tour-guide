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
 * A simple {@link Fragment} to display the list of top sites.
 */

public class TopSitesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);

        final ArrayList<Attraction> topSites = new ArrayList<>();
        topSites.add(new Attraction(getString(R.string.colosseum), getString(R.string.colosseum_address), getString(R.string.colosseum_opening_hours), R.drawable.top_site));
        topSites.add(new Attraction(getString(R.string.trevi_fountain), getString(R.string.trevi_fountain_address), R.drawable.top_site));
        topSites.add(new Attraction(getString(R.string.roman_forum), getString(R.string.roman_forum_address), getString(R.string.roman_forum_opening_hours), R.drawable.top_site));
        topSites.add(new Attraction(getString(R.string.borghese_gallery), getString(R.string.borghese_gallery_address), getString(R.string.borghese_gallery_opening_hours), R.drawable.top_site));

        AttractionAdapter adapter = new AttractionAdapter(getContext(), topSites);
        binding.list.setAdapter(adapter);

        binding.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Attraction attraction = topSites.get(i);
                Intent intent = new Intent(getActivity(), AttractionActivity.class);
                intent.putExtra(getString(R.string.attraction), attraction);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}
