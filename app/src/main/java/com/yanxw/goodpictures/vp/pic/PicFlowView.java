package com.yanxw.goodpictures.vp.pic;

import com.yanxw.goodpictures.model.pic.PicInfoList;
import com.yanxw.goodpictures.vp.BaseView;

/**
 * Created by yanxinwei on 16/8/4.
 */

public interface PicFlowView extends BaseView{

    void refresh(PicInfoList picList);

}
