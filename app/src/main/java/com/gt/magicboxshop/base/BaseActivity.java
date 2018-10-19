package com.gt.magicboxshop.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Time:2018/10/13
 * Author:Gaodi.
 * Description:
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(getLayoutId());

        initView();
        initData();
        initListener();

    }



    public abstract int getLayoutId();

    public abstract void initData();

    public abstract void initView(

    );

    public abstract void initListener();


}
