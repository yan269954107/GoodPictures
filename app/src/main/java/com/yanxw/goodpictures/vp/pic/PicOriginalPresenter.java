package com.yanxw.goodpictures.vp.pic;

import com.yanxw.goodpictures.common.utils.rx.RxSubscribe;
import com.yanxw.goodpictures.common.utils.rx.RxUtils;
import com.yanxw.goodpictures.model.pic.PicList;
import com.yanxw.goodpictures.repository.pic.PicRepository;
import com.yanxw.goodpictures.vp.BasePresenter;

/**
 * PicOriginalPresenter
 * Created by yanxinwei on 16/8/26.
 */

public class PicOriginalPresenter extends BasePresenter<PicOriginalView> {

    @Override
    public void attachView(PicOriginalView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void loadData(String url) {

        PicRepository.getInstance().getPicList(url)
                .compose(RxUtils.getTransformer())
                .subscribe(new RxSubscribe<PicList>() {
                    @Override
                    protected void _onNext(PicList picList) {
                        if (url.equals(picList.getNextPageUrl())) {
                            picList.setNextPageUrl("");
                        }
                        getView().appendData(picList);
                    }
                });

    }

}
