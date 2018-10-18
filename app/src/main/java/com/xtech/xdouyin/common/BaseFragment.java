package com.xtech.xdouyin.common;

import android.support.v4.app.Fragment;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseFragment extends Fragment{


    private CompositeDisposable mDisposables;

    protected void addDisposable(Disposable disposable){
        if(mDisposables == null){
            mDisposables = new CompositeDisposable();
        }

        mDisposables.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mDisposables!=null){
            mDisposables.clear();
        }
    }
}
