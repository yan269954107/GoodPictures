package com.yanxw.goodpictures.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yanxw.goodpictures.ui.fragment.main.GifFragment;
import com.yanxw.goodpictures.ui.fragment.main.HomeFragment;
import com.yanxw.goodpictures.ui.fragment.main.PersonalFragment;
import com.yanxw.goodpictures.ui.fragment.main.SearchFragment;

/**
 * Created by yanxinwei on 16/8/2.
 */

public class MainFragmentAdapter extends FragmentPagerAdapter {

    public static final int MAIN_FRAGMENT_COUNT = 4;

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return HomeFragment.newInstance();
            case 1:
                return GifFragment.newInstance();
            case 2:
                return SearchFragment.newInstance();
            case 3:
                return PersonalFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return MAIN_FRAGMENT_COUNT;
    }
}
