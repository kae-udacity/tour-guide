package com.example.android.tourguide.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.tourguide.R;
import com.example.android.tourguide.fragment.NightlifeFragment;
import com.example.android.tourguide.fragment.ParksFragment;
import com.example.android.tourguide.fragment.RestaurantsFragment;
import com.example.android.tourguide.fragment.TopSitesFragment;

/**
 * Represents each category of attractions as a fragment.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TopSitesFragment();
            case 1:
                return new RestaurantsFragment();
            case 2:
                return new NightlifeFragment();
            default:
                return new ParksFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getResources().getString(R.string.top_sites);
            case 1:
                return mContext.getResources().getString(R.string.restaurants);
            case 2:
                return mContext.getResources().getString(R.string.nightlife);
            default:
                return mContext.getResources().getString(R.string.parks);
        }
    }
}
