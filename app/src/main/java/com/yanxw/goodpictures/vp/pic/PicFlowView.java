package com.yanxw.goodpictures.vp.pic;

import com.yanxw.goodpictures.model.pic.tiangou.TgList;
import com.yanxw.goodpictures.vp.BaseView;

import java.util.List;

/**
 * Created by yanxinwei on 16/8/4.
 */

public interface PicFlowView extends BaseView{

    void refresh(List<TgList.PicturesInfo> picturesInfoList);

}
