package com.yanxw.goodpictures.api.pic.tiangou;

import com.yanxw.goodpictures.model.pic.tiangou.TgList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yanxinwei on 16/7/21.
 */
public interface TianGouApi {

    @GET("list")
    Observable<TgList> getPicList(@Query("id") int id, @Query("page") int page);

}
