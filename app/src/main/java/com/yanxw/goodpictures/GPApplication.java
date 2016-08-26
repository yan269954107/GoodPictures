package com.yanxw.goodpictures;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.maxleap.MaxLeap;

import static com.yanxw.goodpictures.api.pic.ApiInterface.okHttpClient;

/**
 * GPApplication
 * Created by yanxinwei on 16/8/3.
 */

public class GPApplication extends Application {

    private static GPApplication sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;

        initFresco();
        initMaxLeap();
    }

    private void initFresco() {
        ImagePipelineConfig config = OkHttpImagePipelineConfigFactory
                .newBuilder(this, okHttpClient)
                .build();
        Fresco.initialize(this, config);
    }

    private void initMaxLeap() {
        MaxLeap.initialize(this, "57bd052371f55e0007b535f3", "dXByMTdpdUVKdXNIOElhRnNzdm5pQQ", MaxLeap.REGION_CN);

        //测试项目配置：
//        MLDataManager.fetchInBackground(MLObject.createWithoutData("foobar", "123"),
//                new GetCallback<MLObject>() {
//                    @Override
//                    public void done(MLObject mlObject, MLException e) {
//                        if (e != null && e.getCode() == MLException.INVALID_OBJECT_ID) {
//                            Log.d("MaxLeap", "SDK 成功连接到你的云端应用！");
//                        } else {
//                            Log.d("MaxLeap", "应用访问凭证不正确，请检查。");
//                        }
//                    }
//                });
    }

    public static GPApplication getInstance() {
        return sApplication;
    }
}
