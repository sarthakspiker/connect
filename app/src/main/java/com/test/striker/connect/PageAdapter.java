package com.test.striker.connect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by sarthak on 23/6/17.
 */

public class PageAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[]{"Feed", "Contacts", "Profile", "Stats"};

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {

            return new WallFragment();
        } else if (position == 1) {
            return new ContactsFragment();
        } else if (position == 2) {
            return new ProfileFragment();
        } else {
            return new StatsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}