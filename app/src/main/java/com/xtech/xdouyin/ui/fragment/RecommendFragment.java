package com.xtech.xdouyin.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xtech.xdouyin.R;
import com.xtech.xdouyin.common.BaseFragment;
import com.xtech.xdouyin.ui.adapter.VideoPagerAdapter;
import com.xtech.xdouyin.widget.FullscreenVideoView;
import com.xtech.xdouyin.widget.VerticalViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author     : lhu
 * Date       : 2018/10/11
 * Description:
 */

public class RecommendFragment extends BaseFragment {

    @BindView(R.id.vertical_view_pager)
    VerticalViewPager verticalViewPager;
    @BindView(R.id.iv_home_left)
    ImageView ivHomeLeft;
    @BindView(R.id.iv_home_right)
    ImageView ivHomeRight;

    public static RecommendFragment getInstance() {
        return new RecommendFragment();
    }

//    private VerticalPagerAdapter mAdapter;
    private VideoPagerAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, null);
        ButterKnife.bind(this, view);

        initData();
        return view;

    }

    private void initData() {
        List<Integer> list = new ArrayList<>();
//        list.add(R.drawable.banner1);
//        list.add(R.drawable.banner2);
//        list.add(R.drawable.banner3);
        list.add(R.raw.video10);
        list.add(R.raw.video11);
        list.add(R.raw.video12);
        list.add(R.raw.video13);
        list.add(R.raw.video14);

        mAdapter = new VideoPagerAdapter(getChildFragmentManager(),list);

        verticalViewPager.setAdapter(mAdapter);

        verticalViewPager.setOffscreenPageLimit(1);


//        mAdapter = new VerticalPagerAdapter(getActivity(), list);
//
//        verticalViewPager.setAdapter(mAdapter);
//
        verticalViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                //如果是最后一页，则自动加载更多数据
                if(i==mAdapter.getCount()-1){
                    addData();
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.iv_home_left, R.id.iv_home_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_home_left:
                addData();
                break;
            case R.id.iv_home_right:
                break;
        }
    }

    public void addData(){
        List<Integer> list = new ArrayList<>();
        list.add(R.raw.video10);
        list.add(R.raw.video11);
        mAdapter.addData(list);
    }
}
