package com.xtech.xdouyin.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xtech.xdouyin.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author     : lhu
 * Date       : 2018/10/11
 * Description:
 */

public class CommonFragment extends Fragment {

    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.rl_content)
    RelativeLayout rlContent;

    public static CommonFragment getInstance(String page, int color) {

        CommonFragment fragment = new CommonFragment();

        Bundle bundle = new Bundle();
        bundle.putString("page", page);
        bundle.putInt("color", color);
        fragment.setArguments(bundle);

        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common, null);
        ButterKnife.bind(this, view);

        final String page = getArguments().getString("page");

        tvContent.setText(page);
        rlContent.setBackgroundColor(getArguments().getInt("color"));

        tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),page,Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
