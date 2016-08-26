package com.yanxw.goodpictures.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.yanxw.goodpictures.R;
import com.yanxw.goodpictures.adapter.MainFragmentAdapter;
import com.yanxw.goodpictures.adapter.PicListAdapter;
import com.yanxw.goodpictures.ui.BaseActivity;

public class MainActivity extends BaseActivity {

    private BottomBar mBottomBar;

    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = (ViewPager) findViewById(R.id.vp_container);
        mBottomBar = BottomBar.attach(this, savedInstanceState, ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, R.color.colorPrimary), 0.25f);
        mBottomBar.setItems(R.menu.main_bb_menu);

        mBottomBar.setOnMenuTabClickListener(mListener);

        initPictureHeight();

        mPager.setOffscreenPageLimit(MainFragmentAdapter.MAIN_FRAGMENT_COUNT);
        mPager.setAdapter(new MainFragmentAdapter(getSupportFragmentManager()));
        mPager.addOnPageChangeListener(mPageListener);

    }

    private void initPictureHeight() {
        DisplayMetrics dm =getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        PicListAdapter.PICTURE_HEIGHT = (int) (width / 2 * 1.5);
    }

    private OnMenuTabClickListener mListener = new OnMenuTabClickListener() {
        @Override
        public void onMenuTabSelected(@IdRes int menuItemId) {
            switch (menuItemId) {
                case R.id.bb_menu_main:
                    mPager.setCurrentItem(0);
                    break;
                case R.id.bb_menu_gif:
                    mPager.setCurrentItem(1);
                    break;
                case R.id.bb_menu_search:
                    mPager.setCurrentItem(2);
                    break;
                case R.id.bb_menu_personal:
                    mPager.setCurrentItem(3);
                    break;
            }

        }

        @Override
        public void onMenuTabReSelected(@IdRes int menuItemId) {

        }
    };

    private ViewPager.OnPageChangeListener mPageListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            mBottomBar.selectTabAtPosition(position, true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mBottomBar.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
