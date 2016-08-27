package com.yanxw.goodpictures.model.pic;

import java.util.ArrayList;
import java.util.List;

/**
 * PicList
 * Created by yanxinwei on 16/8/26.
 */

public class PicList {

    private String nextPageUrl;

    private List<PicDetail> mPicDetails;

    public void addPicDetail(String url) {
        if (mPicDetails == null) {
            mPicDetails = new ArrayList<>();
        }
        mPicDetails.add(new PicDetail(url));
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public List<PicDetail> getPicDetails() {
        return mPicDetails;
    }

    public void setPicDetails(List<PicDetail> picDetails) {
        mPicDetails = picDetails;
    }

    public class PicDetail {
        private String picUrl;

        public PicDetail(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }
    }

}
