package com.yanxw.goodpictures.model.pic;

import java.util.ArrayList;
import java.util.List;

/**
 * PicInfoList
 * Created by yanxinwei on 16/8/25.
 */

public class PicInfoList {

    private List<PicInfo> mPicInfos;

    private String nextPageUrl;

    public List<PicInfo> getPicInfos() {
        return mPicInfos;
    }

    public void setPicInfos(List<PicInfo> picInfos) {
        mPicInfos = picInfos;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public void addPicInfo(String listUrl, String thumbUrl, String description) {
        if (mPicInfos == null) {
            mPicInfos = new ArrayList<>();
        }
        mPicInfos.add(new PicInfo(listUrl, thumbUrl, description));
    }

    public class PicInfo {
        private String listUrl;
        private String thumbUrl;
        private String description;

        public PicInfo() {
        }

        public PicInfo(String listUrl, String thumbUrl, String description) {
            this.listUrl = listUrl;
            this.thumbUrl = thumbUrl;
            this.description = description;
        }

        public String getListUrl() {
            return listUrl;
        }

        public void setListUrl(String listUrl) {
            this.listUrl = listUrl;
        }

        public String getThumbUrl() {
            return thumbUrl;
        }

        public void setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

}
