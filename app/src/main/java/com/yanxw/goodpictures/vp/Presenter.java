package com.yanxw.goodpictures.vp;

/**
 * Presenter interface
 * Created by yanxinwei on 16/7/24.
 */
public interface Presenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

}
