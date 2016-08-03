package com.yanxw.goodpictures.vp;

/**
 * BasePresenter
 * Created by yanxinwei on 16/7/24.
 */
public class BasePresenter<T extends BaseView> implements Presenter<T>{

    private T mView;

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    public boolean isViewAttached() {
        return mView != null;
    }

    public T getView() {
        return mView;
    }
}
