package com.yanxw.goodpictures.repository.pic;

import android.content.res.AssetManager;

import com.yanxw.goodpictures.GPApplication;
import com.yanxw.goodpictures.model.pic.tiangou.TgClassify;

import java.io.IOException;
import java.io.ObjectInputStream;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by yanxinwei on 16/8/3.
 */

public class TgRepository implements ITgRepository {

    private TgRepository(){};

    private static TgRepository sRepository;

    public static TgRepository getInstance() {
        if (null == sRepository) {
            synchronized (TgRepository.class) {
                if (null == sRepository) {
                    sRepository = new TgRepository();
                }
            }
        }
        return sRepository;
    }

    @Override
    public Observable<TgClassify> getCategory() {
        return Observable.create(new Observable.OnSubscribe<TgClassify>() {

            @Override
            public void call(Subscriber<? super TgClassify> subscriber) {
                try {
                    AssetManager assetManager = GPApplication.getInstance().getAssets();
                    ObjectInputStream ois = new ObjectInputStream(assetManager.open(ASSETS_CATEGORY));
                    TgClassify tgClassify = (TgClassify) ois.readObject();
                    subscriber.onNext(tgClassify);
                } catch (IOException | ClassNotFoundException e) {
                    subscriber.onError(e);
                }
            }
        });
    }

}
