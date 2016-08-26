package com.yanxw.goodpictures.crawler;

import org.jsoup.select.Elements;

/**
 * CrawlerUtils
 * Created by yanxinwei on 16/8/25.
 */

public class CrawlerUtils {

    public static final String getUrl(String siteAddress, String url) {
        if (url.startsWith("http://") || url.startsWith("https://")) {
            return url;
        } else {
            return siteAddress + url;
        }
    }

    public static final int getBigSize(Elements ...elements) {
        int max = 0;
        for (Elements els : elements) {
            if (els.size() > max) {
                max = els.size();
            }
        }
        return max;
    }

}
