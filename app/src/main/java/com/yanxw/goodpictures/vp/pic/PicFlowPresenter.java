package com.yanxw.goodpictures.vp.pic;

import com.yanxw.goodpictures.common.utils.rx.RxSubscribe;
import com.yanxw.goodpictures.common.utils.rx.RxUtils;
import com.yanxw.goodpictures.model.pic.PicInfoList;
import com.yanxw.goodpictures.repository.pic.PicRepository;
import com.yanxw.goodpictures.vp.BasePresenter;

/**
 * Created by yanxinwei on 16/8/5.
 */

public class PicFlowPresenter extends BasePresenter<PicFlowView>{

    @Override
    public void attachView(PicFlowView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void loadData(String url) {

        PicRepository.getInstance().getPicInfoList(url)
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
