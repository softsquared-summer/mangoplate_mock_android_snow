package com.example.mangoplate_snow.src.main.discount;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DiscountFragmentPagerAdapter extends FragmentPagerAdapter {
    public List<Fragment> mFragments = new ArrayList<>();
    public List<String> mFragmentTitles = new ArrayList<>();

    public DiscountFragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    @NotNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }
}