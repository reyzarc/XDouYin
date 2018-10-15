package com.xtech.xdouyin.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xtech.xdouyin.ui.fragment.VideoFragment;

import java.util.List;

/**
 * Author     : lhu
 * Date       : 2018/10/15
 * Description:
 */

public class VideoPagerAdapter extends FragmentPagerAdapter {

    private List<Integer> mList;

    public VideoPagerAdapter(FragmentManager fm, List<Integer> list) {
        super(fm);
        mList = list;
    }

    public void addData(List<Integer> list){
        if (mList != null) {
            mList.addAll(list);
        }
        notifyDataSetChanged();
    }


    @Override
    public Fragment getItem(int i) {
        return VideoFragment.getInstance(mList.get(i));
    }

    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }
}
