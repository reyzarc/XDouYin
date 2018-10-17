package com.xtech.xdouyin;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.xtech.xdouyin.common.BaseActivity;
import com.xtech.xdouyin.ui.adapter.HomePagerAdapter;
import com.xtech.xdouyin.ui.model.event.FragmentChangeEvent;
import com.xtech.xdouyin.utils.RxBus;
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

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                RxBus.getInstance().postEvent(new FragmentChangeEvent(i!=1));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
