package com.yanxw.goodpictures;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import static com.yanxw.goodpictures.api.pic.ApiInterface.okHttpClient;

/**
 * Created by yanxinwei on 16/8/3.
 */

public class GPApplication extends Application {

    private static GPApplication sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        ImagePipelineConfig config = OkHttpImagePipelineConfigFactory
                .newBuilder(this, okHttpClient)
                .build();
        Fresco.initialize(this, config);
    }

    public static GPApplication getInstance() {
        return sApplication;
    }
}
