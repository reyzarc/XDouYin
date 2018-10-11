package com.xtech.xdouyin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.xtech.xdouyin.common.BaseActivity;
import com.xtech.xdouyin.ui.fragment.CommonFragment;
import com.xtech.xdouyin.ui.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


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


    private Fragment mFromFragment, mHomeFragment, mWaterFragment, mFireFragment, mPhotoFragment, mMeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //默认显示第一个页面
        if (mHomeFragment == null) {
            mHomeFragment = HomeFragment.getInstance();
        }
        switchFragment(mHomeFragment);
    }

    @OnClick({R.id.iv_home, R.id.iv_water, R.id.iv_photo, R.id.iv_fire, R.id.iv_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_home:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.getInstance();
                }
                switchFragment(mHomeFragment);
                break;
            case R.id.iv_water:
                if (mWaterFragment == null) {
                    mWaterFragment = CommonFragment.getInstance("water",R.color.black);
                }
                switchFragment(mWaterFragment);
                break;
            case R.id.iv_photo:
                if (mPhotoFragment == null) {
                    mPhotoFragment = CommonFragment.getInstance("photo",R.color.red);
                }
                switchFragment(mPhotoFragment);
                break;
            case R.id.iv_fire:
                if (mFireFragment == null) {
                    mFireFragment = CommonFragment.getInstance("fire",R.color.green);
                }
                switchFragment(mFireFragment);
                break;
            case R.id.iv_me:
                if (mMeFragment == null) {
                    mMeFragment = CommonFragment.getInstance("me",R.color.yellow);
                }
                switchFragment(mMeFragment);
                break;
        }
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
                getSupportFragmentManager().beginTransaction().add(R.id.main_content, desFragment).commit();
            } else {
                getSupportFragmentManager().beginTransaction().hide(mFromFragment).add(R.id.main_content, desFragment).commit();
            }
        } else {//跳转的页面已添加
            getSupportFragmentManager().beginTransaction().hide(mFromFragment).show(desFragment).commit();
        }
        mFromFragment = desFragment;
    }
}
