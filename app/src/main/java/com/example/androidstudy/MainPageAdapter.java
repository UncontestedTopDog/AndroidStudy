package com.example.androidstudy;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String[] titles;

    public MainPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public void setData(List<Fragment> data, String[] titles) {
        if (fragments == null) {
            fragments = new ArrayList<>();
        }
        fragments.addAll(data);
        this.titles = titles;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (fragments != null && fragments.size() > position) {
            return fragments.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if (fragments != null) {
            return fragments.size();
        }
        return 0;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (titles != null && titles.length > position) {
            return titles[position];
        }
        return super.getPageTitle(position);
    }
}
