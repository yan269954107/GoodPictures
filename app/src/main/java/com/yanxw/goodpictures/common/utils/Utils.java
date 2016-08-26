package com.yanxw.goodpictures.common.utils;

import com.yanxw.goodpictures.GPApplication;

/**
 * Utils
 * Created by yanxinwei on 16/8/25.
 */

public class Utils {

    public static final String getStr(int resId) {
        return GPApplication.getInstance().getString(resId);
    }

}
