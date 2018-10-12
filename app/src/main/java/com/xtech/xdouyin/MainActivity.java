package com.xtech.xdouyin;

import android.os.Bundle;

import com.xtech.xdouyin.common.BaseActivity;
import com.xtech.xdouyin.ui.adapter.HomePagerAdapter;
import com.xtech.xdouyin.widget.NoScrollViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.view_pager)
    NoScrollViewPager viewPager;

    private HomePagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        mAdapter = new HomePagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);

        viewPager.setCurrentItem(1);
    }
}
