package com.gt.mymagicboxapp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.gt.mymagicboxapp.DropdownLayout;
import com.gt.mymagicboxapp.R;
import com.gt.mymagicboxapp.utils.LogUtil;
import com.gt.mymagicboxapp.utils.ToastUtil;

import butterknife.ButterKnife;

/**
 * Time:2018/10/13
 * Author:Gaodi.
 * Description:
 */
public abstract class BaseActivity extends AppCompatActivity {

    private float y1;
    private float y2;
    private DropdownLayout mDropdownView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);


//        imgToolBarBack = (ImageView) findViewById(R.id.toolbar_back);
//        imgToolBarBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//                LogUtil.v("toolbar返回！");
//            }
//        });

/*        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){

            setSupportActionBar(toolbar);
            mToolBarHelper = new ToolBarHelper(toolbar);
            handleToolBar(mToolBarHelper);
        }*/

        initView();
        initData();
        initListener();

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //继承了Activity的onTouchEvent方法，直接监听点击事件
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //当手指按下的时候
            y1 = event.getY();
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {

            y2 = event.getY();

            if (y1 - y2 > 300) {
                ToastUtil.showShortToast("向上滑");
            } else if (y2 - y1 > 300) {
                ToastUtil.showShortToast("向下滑");
            }

        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            //当手指离开的时候

            ToastUtil.showShortToast("手机离开");
        }
        return super.onTouchEvent(event);

    }


    public abstract int getLayoutId();

    public abstract void initData();

    public abstract void initView(

    );

    public abstract void initListener();


}
