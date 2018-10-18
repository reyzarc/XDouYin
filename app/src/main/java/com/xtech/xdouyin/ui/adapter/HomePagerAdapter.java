package com.xtech.xdouyin.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xtech.xdouyin.ui.fragment.DetailFragment;
import com.xtech.xdouyin.ui.fragment.HomeFragment;
import com.xtech.xdouyin.ui.fragment.MoreFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Author     : lhu
 * Date       : 2018/10/11
 * Description:
 */

public class HomePagerAdapter extends FragmentPagerAdapter {

    List<Fragment> mList;

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);

        mList = new ArrayList<>();

        mList.add(MoreFragment.getInstance());
        mList.add(HomeFragment.getInstance());
        mList.add(DetailFragment.getInstance());
    }

    @Override
    public Fragment getItem(int i) {
        if (mList != null && !mList.isEmpty()) {
            return mList.get(i);
        }
        return null;
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
