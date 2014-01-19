package com.frankdu.cool.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.frankdu.cool.R;
import com.frankdu.cool.fragment.IntroFragment;
import com.frankdu.cool.fragment.PictureFragment;

public class MainCoolActivity extends BaseCoolActivity {

    private static final int NUM_PAGES = 2;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_feed);

        mViewPager = getView(R.id.view_pager);
        mViewPager.setAdapter(new ScreenSlidePagerAdapter(getSupportFragmentManager()));
    }

    @Override
    public void onBackPressed() {
        if (mViewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, slide to the previous step.
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: {
                    return new IntroFragment();
                }

                case 1: {
                    return new PictureFragment();
                }

                default:
                    break;
            }
            throw new RuntimeException("No fragment defined for position: " + position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}