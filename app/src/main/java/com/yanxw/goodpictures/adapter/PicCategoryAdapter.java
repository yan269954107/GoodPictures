package com.yanxw.goodpictures.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by yanxinwei on 16/8/3.
 */

public class PicCategoryAdapter extends FragmentStatePagerAdapter{

    private Context mContext;
    private ArrayList<Fragment> mFragments;
    private String[] mTitles;

    public PicCategoryAdapter(FragmentManager fm, Context context, ArrayList<Fragment> fragments,
                              String[] titles) {
        super(fm);
        mContext = context;
        mFragments = fragments;
        mTitles = titles;
    }

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
        return mTitles[position];
    }
}
