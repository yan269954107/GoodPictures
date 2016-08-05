package com.yanxw.goodpictures.common.utils;

import android.content.Context;
import android.widget.Toast;

import com.yanxw.goodpictures.GPApplication;

/**
 * Created by yanxinwei on 16/8/3.
 */

public class T {

    private static Toast sToast;

    /**
     * 短时间显示  Toast
     *
     * @param context
     * @param sequence
     */
    public static void showShort(Context context, CharSequence sequence) {

        if (sToast == null) {
            sToast = Toast.makeText(context, sequence, Toast.LENGTH_SHORT);

        } else {
            sToast.setText(sequence);
        }
        sToast.show();

    }

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, int message) {
        if (null == sToast) {
            sToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(message);
        }
        sToast.show();
    }

    public static void showShort(int message) {
        if (null == sToast) {
            sToast = Toast.makeText(GPApplication.getInstance(), message, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(message);
        }
        sToast.show();
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, CharSequence message) {
        if (null == sToast) {
            sToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        } else {
            sToast.setText(message);
        }
        sToast.show();
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, int message) {
        if (null == sToast) {
            sToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
            //    sToast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            sToast.setText(message);
        }
        sToast.show();
    }

    /**
     * 隐藏toast
     */
    public static void hideToast() {
        if (sToast != null) {
            sToast.cancel();
        }
    }

}
