package com.yanxw.goodpictures.vp.pic;

import com.yanxw.goodpictures.model.pic.PicList;
import com.yanxw.goodpictures.vp.LoadingView;

/**
 * PicOriginalView
 * Created by yanxinwei on 16/8/26.
 */

public interface PicOriginalView extends LoadingView {

    void appendData(PicList picList);

}
