package com.yanxw.goodpictures.model.pic;

import com.yanxw.goodpictures.crawler.CommonCrawler;

import java.util.ArrayList;
import java.util.List;

/**
 * PicCategories
 * Created by yanxinwei on 16/8/25.
 */

public class PicCategories {

    public static final String DEFAULT_CATEGORY = "美女";

    private List<PicCategory> mCategories;

    public List<PicCategory> getCategories() {
        return mCategories;
    }

    public void setCategories(List<PicCategory> categories) {
        mCategories = categories;
    }

    public void addPicCategory(String name, String url) {
        if (mCategories == null) {
            mCategories = new ArrayList<>(CommonCrawler.CATEGORY_LIMITS);
        }
        PicCategory picCategory = new PicCategory(name, url);
        mCategories.add(picCategory);
    }

    public class PicCategory {
        private String name;
        private String url;

        PicCategory(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}
