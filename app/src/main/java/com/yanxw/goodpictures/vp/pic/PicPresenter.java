package com.yanxw.goodpictures.vp.pic;

import com.yanxw.goodpictures.GPApplication;
import com.yanxw.goodpictures.R;
import com.yanxw.goodpictures.api.pic.tiangou.TianGouService;
import com.yanxw.goodpictures.common.utils.T;
import com.yanxw.goodpictures.model.pic.tiangou.TgList;
import com.yanxw.goodpictures.vp.BasePresenter;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by yanxinwei on 16/8/5.
 */

public class PicPresenter extends BasePresenter<PicFlowView>{

    @Override
    public void attachView(PicFlowView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void loadData(int id, int page) {

        TianGouService.getTianGouApi().getPicList(id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<TgList>() {
                    @Override
                    public void call(TgList tgList) {
                        if (tgList.isStatus()) {
                            getView().refresh(tgList.getTngou());
                        } else {
                            T.showShort(R.string.error_request_failed);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                        T.showShort(GPApplication.getInstance(), R.string.error_network);
                    }
                });

    }
}
