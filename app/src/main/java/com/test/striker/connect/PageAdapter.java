package com.test.striker.connect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by sarthak on 23/6/17.
 */

public class PageAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[]{"Feed", "Contacts", "Profile"};

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {

            return new WallFragment();
        } else if (position == 1) {
            return new ContactsFragment();
        } else {
            return new ProfileFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}