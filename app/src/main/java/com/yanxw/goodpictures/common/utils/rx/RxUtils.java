package com.yanxw.goodpictures.common.utils.rx;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * RxUtils
 * Created by yanxinwei on 16/8/23.
 */

public class RxUtils {

    public static final int DEFAULT_TIMEOUT = 10;

    public static <T> Observable.Transformer<T, T> getTransformer() {
        return tObservable -> tObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
