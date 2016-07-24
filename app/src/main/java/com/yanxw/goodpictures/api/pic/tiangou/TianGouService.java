package com.yanxw.goodpictures.api.pic.tiangou;

import com.yanxw.goodpictures.api.pic.ApiInterface;

import retrofit2.Retrofit;

/**
 * Created by yanxinwei on 16/7/21.
 */
public class TianGouService {

    private static final String TIANGOU_API_BASE = "http://www.tngou.net/";
    private static final String TIANGOU_IMG_BASE = "http://tnfs.tngou.net/";

    private static TianGouApi sTianGouApi;
    private static TianGouImgApi sTianGouImgApi;

    public static TianGouApi getTianGouApi() {
        if (sTianGouApi == null) {
            synchronized (TianGouService.class) {
                if (sTianGouApi == null) {
                    Retrofit retrofit = ApiInterface.builder.baseUrl(TIANGOU_API_BASE).build();
                    sTianGouApi = retrofit.create(TianGouApi.class);
                }
            }
        }
        return sTianGouApi;
    }

    public static TianGouImgApi getTianGouImgApi() {
        if (sTianGouImgApi == null) {
            synchronized (TianGouService.class) {
                if (sTianGouImgApi == null) {
                    Retrofit retrofit = ApiInterface.builder.baseUrl(TIANGOU_IMG_BASE).build();
                    sTianGouImgApi = retrofit.create(TianGouImgApi.class);
                }
            }
        }
        return sTianGouImgApi;
    }

}
