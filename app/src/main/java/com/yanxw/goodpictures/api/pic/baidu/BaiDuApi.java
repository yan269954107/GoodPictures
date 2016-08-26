package com.yanxw.goodpictures.api.pic.baidu;

import com.yanxw.goodpictures.model.pic.baidu.BdList;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yanxinwei on 16/8/23.
 */

public interface BaiDuApi {

    @GET("imgs?col=美女&tag={tag}&sort=0&tag3=&pn={page}&rn={pageSize}&p=channel&from=1")
    Observable<BdList> getPicList(@Path("tag") String tag, @Path("page") int page, @Path("pageSize") int pageSize);

}
