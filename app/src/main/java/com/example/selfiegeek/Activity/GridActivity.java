package com.example.selfiegeek.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.selfiegeek.AppPrefrences;
import com.example.selfiegeek.Fragment.ImagesGridFragment;
import com.example.selfiegeek.Fragment.VideosGridFragment;
import com.example.selfiegeek.R;

import java.util.Set;

public class GridActivity extends AppCompatActivity {

        private static final String TAG = "GridActivity";
        ViewPager pager;
        private PagerAdapter mPagerAdapter;
        public static Set<String> imageList;
        public static  Set<String> videoList ;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_grid);

            pager = (ViewPager) findViewById(R.id.viewPager);
            mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
            pager.setAdapter(mPagerAdapter);
            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(pager);
            AppPrefrences appPrefrences = new AppPrefrences();
            imageList=  appPrefrences.getImageList(this);
        System.out.print("image list "+imageList);
        Log.e("image list ", String.valueOf(imageList));
            videoList =  appPrefrences.getVideoList(this);
    }

        private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

            final int PAGE_COUNT = 2;
            private String tabTitles[] = new String[] { "Images", "Videos"};

            ScreenSlidePagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new ImagesGridFragment();
                    case 1:
                        return new VideosGridFragment();
                }
                return null;
            }

            @Override
            public int getCount() {
                return PAGE_COUNT;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabTitles[position];
            }

        }

    }
