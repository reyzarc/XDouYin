package com.xtech.xdouyin;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.xtech.xdouyin.common.BaseActivity;
import com.xtech.xdouyin.ui.adapter.HomePagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private HomePagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAdapter = new HomePagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
    }
}
