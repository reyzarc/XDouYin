package com.xtech.xdouyin.ui.model.event;

public class FragmentChangeEvent {
    /**
     * false-showVideo,true-hideVideo
     */
    private boolean isHideVideo;

    public FragmentChangeEvent(boolean isHideVideo){
        this.isHideVideo = isHideVideo;
    }

    public boolean isHideVideo() {
        return isHideVideo;
    }

    public void setHideVideo(boolean hideVideo) {
        isHideVideo = hideVideo;
    }
}
