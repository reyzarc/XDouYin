package com.xtech.xdouyin.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.xtech.xdouyin.MainActivity;
import com.xtech.xdouyin.R;
import com.xtech.xdouyin.widget.NoScrollViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment {


    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.iv_water)
    ImageView ivWater;
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;
    @BindView(R.id.iv_fire)
    ImageView ivFire;
    @BindView(R.id.iv_me)
    ImageView ivMe;
    @BindView(R.id.main_content)
    FrameLayout mainContent;

    private Fragment mFromFragment,mRecommendFragment, mWaterFragment, mFireFragment, mPhotoFragment, mMeFragment;

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    private boolean isHome;

    private NoScrollViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);

        //默认显示第一个页面
        if (mRecommendFragment == null) {
            mRecommendFragment = RecommendFragment.getInstance();
        }
        switchFragment(mRecommendFragment);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MainActivity activity = (MainActivity) getActivity();
        if (activity!=null){
            mViewPager = activity.findViewById(R.id.view_pager);
        }
    }

    @OnClick({R.id.iv_home, R.id.iv_water, R.id.iv_photo, R.id.iv_fire, R.id.iv_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_home:
                if (mRecommendFragment == null) {
                    mRecommendFragment = RecommendFragment.getInstance();
                }
                switchFragment(mRecommendFragment);
                isHome = true;
                break;
            case R.id.iv_water:
                if (mWaterFragment == null) {
                    mWaterFragment = CommonFragment.getInstance("water",R.color.black);
                }
                switchFragment(mWaterFragment);
                isHome = false;
                break;
            case R.id.iv_photo:
                if (mPhotoFragment == null) {
                    mPhotoFragment = CommonFragment.getInstance("photo",R.color.red);
                }
                switchFragment(mPhotoFragment);
                isHome = false;
                break;
            case R.id.iv_fire:
                if (mFireFragment == null) {
                    mFireFragment = CommonFragment.getInstance("fire",R.color.green);
                }
                switchFragment(mFireFragment);
                isHome = false;
                break;
            case R.id.iv_me:
                if (mMeFragment == null) {
                    mMeFragment = CommonFragment.getInstance("me",R.color.yellow);
                }
                switchFragment(mMeFragment);
                isHome = false;
                break;
        }

        mViewPager.setIsCanScroll(isHome);
    }


    /**
     * 切换fragment
     *
     * @param desFragment 即将跳转的fragment
     */
    private void switchFragment(Fragment desFragment) {
        //如果跳转的fragment不存在或者就是当前页面,则不处理
        if (desFragment == null || desFragment == mFromFragment) {
            return;
        }
        if (!desFragment.isAdded()) {//跳转的页面还没有被添加
            if (mFromFragment == null) {//页面不存在
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.main_content, desFragment).commit();
            } else {
                getActivity().getSupportFragmentManager().beginTransaction().hide(mFromFragment).add(R.id.main_content, desFragment).commit();
            }
        } else {//跳转的页面已添加
            getActivity().getSupportFragmentManager().beginTransaction().hide(mFromFragment).show(desFragment).commit();
        }
        mFromFragment = desFragment;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
