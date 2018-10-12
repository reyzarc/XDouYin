package com.xtech.xdouyin.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mList.get(position));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        container.addView(imageView);

        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
