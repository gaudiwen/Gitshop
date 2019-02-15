package com.gt.magicboxshop.proxy;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gt.magicboxshop.delegate.SplashDelegate;
import com.gt.magicboxshop.delegates.PlaneDelegate;

public class SplashActivity extends ProxyActivity {


    @Override
    public PlaneDelegate setRootDelegate() {

        return SplashDelegate.newInstance();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void init() {

    }
}
