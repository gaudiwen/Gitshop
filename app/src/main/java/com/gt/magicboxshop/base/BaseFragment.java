package com.gt.mymagicboxapp.base;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;


/**
 *Time:2018/10/13
 *Author:Gaodi.
 *Description:
 */
public abstract class BaseFragment extends Fragment {

    public abstract View initView(LayoutInflater inflater, ViewGroup container,
                                  Bundle savedInstanceState);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = initView(inflater, container, savedInstanceState);

        ButterKnife.bind(this,view);

        initListener();
        initData();
        return view;
    }

    protected abstract void initListener();

    protected  abstract void initData();
}