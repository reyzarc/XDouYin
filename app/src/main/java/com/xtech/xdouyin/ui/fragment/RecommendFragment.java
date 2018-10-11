package com.xtech.xdouyin.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xtech.xdouyin.R;
import com.xtech.xdouyin.ui.adapter.VerticalPagerAdapter;
import com.xtech.xdouyin.widget.VerticalViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author     : lhu
 * Date       : 2018/10/11
 * Description:
 */

public class RecommendFragment extends Fragment {

    @BindView(R.id.vertical_view_pager)
    VerticalViewPager verticalViewPager;
    @BindView(R.id.iv_home_left)
    ImageView ivHomeLeft;
    @BindView(R.id.iv_home_right)
    ImageView ivHomeRight;

    public static RecommendFragment getInstance() {
        return new RecommendFragment();
    }

    private VerticalPagerAdapter mAdapter;


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
        list.add(R.drawable.banner1);
        list.add(R.drawable.banner2);
        list.add(R.drawable.banner3);

        mAdapter = new VerticalPagerAdapter(getActivity(), list);

        verticalViewPager.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
