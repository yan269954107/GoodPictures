package com.yanxw.goodpictures.vp.pic;

import com.yanxw.goodpictures.GPApplication;
import com.yanxw.goodpictures.R;
import com.yanxw.goodpictures.api.pic.tiangou.TianGouService;
import com.yanxw.goodpictures.common.utils.ToastUtils;
import com.yanxw.goodpictures.common.utils.rx.RxSubscribe;
import com.yanxw.goodpictures.common.utils.rx.RxUtils;
import com.yanxw.goodpictures.model.pic.PicInfoList;
import com.yanxw.goodpictures.repository.pic.PicRepository;
import com.yanxw.goodpictures.vp.BasePresenter;

import rx.android.schedulers.AndroidSchedulers;
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
                .subscribe(tgList -> {
                    if (tgList.isStatus()) {
//                        getView().refresh(tgList.getTngou());
                    } else {
                        ToastUtils.showShort(R.string.error_request_failed);
                    }
                }, throwable -> {
                    throwable.printStackTrace();
                    ToastUtils.showShort(GPApplication.getInstance(), R.string.error_network);
                });

    }

    public void loadData(String url) {

        PicRepository.getInstance().getPicList(url)
                .compose(RxUtils.getTransformer())
                .subscribe(new RxSubscribe<PicInfoList>() {
                    @Override
                    protected void _onNext(PicInfoList picList) {
                        if (url.equals(picList.getNextPageUrl())) {
                            picList.setNextPageUrl("");
                        }
                        getView().refresh(picList);
                    }
                });

    }
}
