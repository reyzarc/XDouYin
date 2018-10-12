package com.xtech.xdouyin.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xtech.xdouyin.R;
import com.xtech.xdouyin.widget.FullscreenVideoView;

import java.util.List;

/**
 * Author     : lhu
 * Date       : 2018/10/11
 * Description:
 */

public class VerticalPagerAdapter extends PagerAdapter {

    private List<Integer> mList;
    private Context mContext;

    public VerticalPagerAdapter(Context context,List<Integer> list){
        mContext = context;
        if(list!=null&&!list.isEmpty()){
            mList = list;
        }
    }

    public void setData(List<Integer> list){
        mList = list;
        notifyDataSetChanged();
    }

    public void addData(List<Integer> list){
        if(mList!=null){
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }




    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_vertical_view_pager,null);

        FullscreenVideoView videoView = view.findViewById(R.id.fullscreen_video_view);
        videoView.setVideoURI(Uri.parse("android.resource://"+mContext.getPackageName()+"/"+ mList.get(position)));

        videoView.start();

//        ImageView imageView = new ImageView(mContext);
//        imageView.setImageResource(mList.get(position));
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
