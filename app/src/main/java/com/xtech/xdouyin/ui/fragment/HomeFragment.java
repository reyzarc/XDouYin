package com.xtech.xdouyin.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xtech.xdouyin.R;
import com.xtech.xdouyin.ui.adapter.HomePagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {


    @BindView(R.id.view_pager)
    ViewPager viewPager;


    private HomePagerAdapter mAdapter;

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);

        initData();
        return view;
    }

    private void initData() {
        mAdapter = new HomePagerAdapter(getChildFragmentManager());

        viewPager.setAdapter(mAdapter);

        viewPager.setCurrentItem(1);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
