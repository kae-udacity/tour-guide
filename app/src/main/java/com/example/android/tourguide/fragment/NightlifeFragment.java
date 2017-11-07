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
 * A simple {@link Fragment} to display the list of bars.
 */

public class NightlifeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);

        final ArrayList<Attraction> bars = new ArrayList<>();
        bars.add(new Attraction(getString(R.string.freni_e_frizioni), getString(R.string.freni_e_frizioni_address), getString(R.string.freni_e_frizioni_opening_hours), R.drawable.bar));
        bars.add(new Attraction(getString(R.string.cul_de_sac), getString(R.string.cul_de_sac_address), getString(R.string.cul_de_sac_opening_hours), R.drawable.bar));
        bars.add(new Attraction(getString(R.string.open_baladin), getString(R.string.open_baladin_address), getString(R.string.open_baladin_opening_hours), R.drawable.bar));
        bars.add(new Attraction(getString(R.string.the_yellow_bar), getString(R.string.the_yellow_bar_address), getString(R.string.the_yellow_bar_opening_hours), R.drawable.bar));

        AttractionAdapter adapter = new AttractionAdapter(getContext(), bars);
        binding.list.setAdapter(adapter);

        binding.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Attraction attraction = bars.get(i);
                Intent intent = new Intent(getActivity(), AttractionActivity.class);
                intent.putExtra(getString(R.string.attraction), attraction);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}
