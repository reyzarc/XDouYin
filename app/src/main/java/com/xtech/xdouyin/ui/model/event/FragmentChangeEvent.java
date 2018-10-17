package com.xtech.xdouyin.ui.model.event;

public class FragmentChangeEvent {
    /**
     * false-showHome,true-hideHome
     */
    private boolean isHideHome;

    public FragmentChangeEvent(boolean isHideHome){
        this.isHideHome = isHideHome;
    }

    public boolean isHideHome() {
        return isHideHome;
    }

    public void setHideHome(boolean hideHome) {
        isHideHome = hideHome;
    }
}
