package com.example.admin.chargingcontrol.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.admin.chargingcontrol.fragments.InfoFragment;
import com.example.admin.chargingcontrol.fragments.ModeFragment;
import com.example.admin.chargingcontrol.fragments.StatisticsFragment;


public class PageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        if(position == 0) return fragment = new ModeFragment();
        else if(position == 1) fragment = new InfoFragment();
        else  fragment = new StatisticsFragment();
        return fragment;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Mode";
            case 1:
                return "Info";
            case 2:
                return "Statistics";
            default:
                return null;
        }
    }
}