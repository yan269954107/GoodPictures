package com.yanxw.goodpictures.repository.pic;

import com.yanxw.goodpictures.model.pic.tiangou.TgClassify;

import rx.Observable;

/**
 * Created by yanxinwei on 16/8/3.
 */

public interface ITgRepository {

    Observable<TgClassify> getCategory();

    String ASSETS_CATEGORY = "pic/category/tg_category";

}
