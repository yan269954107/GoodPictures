package com.yanxw.goodpictures.api.pic.baidu;

import com.yanxw.goodpictures.api.pic.ApiInterface;

import retrofit2.Retrofit;

/**
 * Created by yanxinwei on 16/8/23.
 */

public class BaiDuService {

    private static final String BAIDU_API_BASE = "http://image.baidu.com/data/";

    private static BaiDuApi sBaiDuApi;

    public static BaiDuApi getBaiDuApi() {
        if (null == sBaiDuApi) {
            synchronized (BaiDuService.class) {
                if (null == sBaiDuApi) {
                    Retrofit retrofit = ApiInterface.builder.baseUrl(BAIDU_API_BASE).build();
                    sBaiDuApi = retrofit.create(BaiDuApi.class);
                }
            }
        }
        return sBaiDuApi;
    }



}
