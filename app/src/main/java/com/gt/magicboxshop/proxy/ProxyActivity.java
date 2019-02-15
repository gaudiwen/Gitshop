package com.gt.magicboxshop.proxy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.gt.magicboxshop.R;
import com.gt.magicboxshop.delegates.PlaneDelegate;
import com.gt.magicboxshop.utils.BarUtils;

import me.yokeyword.fragmentation.SupportActivity;

public abstract class ProxyActivity extends SupportActivity {

    public abstract PlaneDelegate setRootDelegate();

    public abstract void  init();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏颜色
        BarUtils.setStatusBarColor(this,getResources().getColor(R.color.color_000000));
        initContainer(savedInstanceState);

    }

    private void initContainer(Bundle savedInstanceState) {

       @SuppressLint("RestrictedApi")
       ContentFrameLayout container =  new ContentFrameLayout(this);
       container.setId(R.id.delegate_container);
       setContentView(container);
       if(savedInstanceState == null){
          loadRootFragment(R.id.delegate_container,setRootDelegate());
       }
        init();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        System.gc();
        System.runFinalization();

    }
}
