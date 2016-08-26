package com.yanxw.goodpictures.common.utils.rx;

import com.yanxw.goodpictures.R;
import com.yanxw.goodpictures.common.Exception.ErrorCodeException;
import com.yanxw.goodpictures.common.utils.ToastUtils;

import java.util.concurrent.TimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by yanxinwei on 16/8/23.
 */

public abstract class RxSubscribe<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {
        _onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ErrorCodeException) {
            ToastUtils.showShort(((ErrorCodeException) e).getErrorDes());
        } else if (e instanceof HttpException) {
            ToastUtils.showShort(R.string.error_network);
        } else if (e instanceof TimeoutException) {
            ToastUtils.showShort(R.string.error_request_timeout);
        } else {
            ToastUtils.showShort(R.string.error_unable_handle);
        }
        _onError(e);
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    protected abstract void _onNext(T t);

    protected void _onError(Throwable e){

    }

    protected void _onCompleted(){

    }
}
