package com.gt.magicboxshop.delegate;

import android.os.Bundle;

import com.gt.magicboxshop.R;
import com.gt.magicboxshop.delegates.PlaneDelegate;

/**
 *Time:2019/2/15
 *Author:Gaodi.
 *Description:
 */
public class SplashDelegate extends PlaneDelegate {

    public static SplashDelegate newInstance() {

        Bundle args = new Bundle();

        SplashDelegate fragment = new SplashDelegate();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Object setLayout() {
        return R.layout.delegate_splash;
    }

    @Override
    protected void initData(Bundle arguments) {

    }

    @Override
    protected void init() {

        setSwipeBackEnable(false);
    }
}
