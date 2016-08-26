package com.yanxw.goodpictures.repository.pic;

import com.yanxw.goodpictures.common.Exception.ErrorCodeException;
import com.yanxw.goodpictures.crawler.MiMiPageProcessor;
import com.yanxw.goodpictures.model.pic.PicCategories;
import com.yanxw.goodpictures.model.pic.PicInfoList;

import rx.Observable;

/**
 * PicRepository
 * Created by yanxinwei on 16/8/25.
 */

public class PicRepository {

    private static PicRepository instance = null;
    
    private PicRepository() {
    }
    
    public static PicRepository getInstance() {
        if (instance == null) {
            synchronized (PicRepository.class) {
                if (instance == null) {
                    instance = new PicRepository();
                }
            }
        }
        return instance;
    }

    public Observable<PicCategories> getPicCategories() {
        return Observable.create(subscriber -> {
            PicCategories picCategories = MiMiPageProcessor.getInstance().getCategory();
            if (null == picCategories) {
                subscriber.onError(new ErrorCodeException(ErrorCodeException.ERROR_PARSE));
            } else {
                subscriber.onNext(picCategories);
            }
        });
    }

    public Observable<PicInfoList> getPicList(String url) {
        return Observable.create(subscriber -> {
            PicInfoList picList = MiMiPageProcessor.getInstance().getPicList(url);
            if (null == picList) {
                subscriber.onError(new ErrorCodeException(ErrorCodeException.ERROR_PARSE));
            } else {
                subscriber.onNext(picList);
            }
        });
    }

}
