package com.xtech.xdouyin.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xtech.xdouyin.R;
import com.xtech.xdouyin.common.BaseFragment;

/**
 * Author     : lhu
 * Date       : 2018/10/11
 * Description:
 */

public class DetailFragment extends BaseFragment {
    public static DetailFragment getInstance(){
        return new DetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail,null);
        return view;
    }
}
