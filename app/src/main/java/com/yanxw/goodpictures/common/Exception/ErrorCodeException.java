package com.yanxw.goodpictures.common.Exception;

import com.yanxw.goodpictures.R;
import com.yanxw.goodpictures.common.utils.Utils;

/**
 * ErrorCodeException
 * Created by yanxinwei on 16/8/23.
 */

public class ErrorCodeException extends Exception{

    public static final int ERROR_SYSTEM = -1;
    public static final int ERROR_PARSE = -2;

    private int code;

    public ErrorCodeException(int code) {
        this.code = code;
    }

    public String getErrorDes() {
        String des;
        switch (code) {
            case ERROR_SYSTEM:
                des = Utils.getStr(R.string.error_unable_handle);
                break;
            case ERROR_PARSE:
                des = Utils.getStr(R.string.error_parse);
                break;
            default:
                des = Utils.getStr(R.string.error_unable_handle);
        }
        return des;
    }


}
