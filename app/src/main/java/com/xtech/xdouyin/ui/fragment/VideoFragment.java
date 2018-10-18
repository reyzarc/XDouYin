package com.xtech.xdouyin.ui.fragment;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xtech.xdouyin.R;
import com.xtech.xdouyin.common.BaseFragment;
import com.xtech.xdouyin.ui.model.event.FragmentChangeEvent;
import com.xtech.xdouyin.utils.PreferenceUtil;
import com.xtech.xdouyin.utils.RxBus;
import com.xtech.xdouyin.widget.FullscreenVideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Author     : lhu
 * Date       : 2018/10/15
 * Description: 视频播放页面
 */

public class VideoFragment extends BaseFragment {

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

        //设置视频路径
        fullscreenVideoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + getArguments().getInt("video")));
        //设置视频到第一帧,产生预览效果
        fullscreenVideoView.seekTo(1);
        //设置视频循环播放
        fullscreenVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                fullscreenVideoView.start();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        //接收fragment页面变化消息，如果videoFragment没有展示给用户，则停止播放，反之则自动播放
        Disposable disposable = RxBus.getInstance().toObservable(FragmentChangeEvent.class).subscribe(new Consumer<FragmentChangeEvent>() {
            @Override
            public void accept(FragmentChangeEvent fragmentChangeEvent) throws Exception {
                if (fullscreenVideoView != null) {
                    if (fragmentChangeEvent.isHideVideo()) {//video已经被隐藏,此时暂停播放
                        if (fullscreenVideoView.isPlaying()) {
                            fullscreenVideoView.pause();
                        }
                    } else {//video展示在前面,则继续播放
                        int video = PreferenceUtil.getInt(getActivity(), "playing_video", -1);
                        if (video != -1 && video == getArguments().getInt("video")) {
                            fullscreenVideoView.start();
                        }
                    }
                }
            }
        });
        addDisposable(disposable);

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        isViewCreated = true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isViewCreated) {
            playVideo(isVisibleToUser);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void playVideo(boolean isPlay) {
        if (isPlay) {
            fullscreenVideoView.start();
            //保存正在播放视频页面的video路径
            PreferenceUtil.putInt(getActivity(), "playing_video", getArguments().getInt("video"));
        } else {
            fullscreenVideoView.stopPlayback();
            fullscreenVideoView.resume();
            fullscreenVideoView.seekTo(1);
        }
    }
}
