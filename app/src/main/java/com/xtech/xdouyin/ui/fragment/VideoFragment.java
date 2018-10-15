package com.xtech.xdouyin.ui.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xtech.xdouyin.R;
import com.xtech.xdouyin.widget.FullscreenVideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author     : lhu
 * Date       : 2018/10/15
 * Description:
 */

public class VideoFragment extends Fragment {

    @BindView(R.id.fullscreen_video_view)
    FullscreenVideoView fullscreenVideoView;

    private boolean isViewCreated;

    public static VideoFragment getInstance(int videoSrc) {
        VideoFragment fragment = new VideoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("video", videoSrc);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, null);
        ButterKnife.bind(this, view);

        fullscreenVideoView.setVideoURI(Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+ getArguments().getInt("video")));

        fullscreenVideoView.seekTo(1);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        isViewCreated = true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if(isViewCreated){
            if(isVisibleToUser){
                fullscreenVideoView.start();
            }else{
                fullscreenVideoView.stopPlayback();
                fullscreenVideoView.resume();
                fullscreenVideoView.seekTo(1);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
