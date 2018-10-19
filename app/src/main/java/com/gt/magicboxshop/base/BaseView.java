package com.gt.magicboxshop.base;



/**
 *Time:2018/10/13
 *Author:Gaodi.
 *Description:
 */
public interface BaseView {

    void showProgress();

    void hideProgress();

    void showLoadFailMsg(Throwable e);
}
