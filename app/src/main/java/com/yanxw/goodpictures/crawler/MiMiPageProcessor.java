package com.yanxw.goodpictures.crawler;

import com.yanxw.goodpictures.model.pic.PicCategories;
import com.yanxw.goodpictures.model.pic.PicInfoList;
import com.yanxw.goodpictures.model.pic.PicList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * "//h1[@class='entry-title public']/strong/a/text()"
 * MiMiPageProcessor
 * Created by yanxinwei on 16/8/25.
 */
public class MiMiPageProcessor {

    private static MiMiPageProcessor instance = null;

    private MiMiPageProcessor() {
    }

    public static MiMiPageProcessor getInstance() {
        if (instance == null) {
            synchronized (MiMiPageProcessor.class) {
                if (instance == null) {
                    instance = new MiMiPageProcessor();
                }
            }
        }
        return instance;
    }

    public PicCategories getCategory() {
        try {
            Document doc = Jsoup.connect(CommonCrawler.URL_MIMITUXIU).get();
            Elements container = doc.select("div[style=background-image:url(Image2/1.gif); width:980px; height:130px; margin-top:8px;]");
            Elements links = container.select("a[href~=^(?!http).*$]");
            PicCategories picCategories = new PicCategories();
            for (Element element : links) {
                picCategories.addPicCategory(element.text(),
                        CrawlerUtils.getUrl(CommonCrawler.URL_MIMITUXIU, element.attr("href")));
            }
            return picCategories;
        } catch (Exception e) {
            return null;
        }
    }

    public PicInfoList getPicInfoList(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select(".photo").select("a[href]");
            Elements imgs = links.select("img[src]");
            PicInfoList picList = new PicInfoList();
            int size = CrawlerUtils.getBigSize(links, imgs);
            for (int i = 0; i < size; i++) {
                Element link = links.get(i);
                Element img = imgs.get(i);
                picList.addPicInfo(CrawlerUtils.getUrl(url, link.attr("href")),
                        img.attr("src"), link.text());
            }
            Elements elements = doc.select("ul.page > a:contains(下一页)");
            if (elements != null && elements.size() > 0) {
                picList.setNextPageUrl(CrawlerUtils.getUrl(url, elements.get(0).attr("href")));
            } else {
                picList.setNextPageUrl("");
            }
            return picList;
        } catch (Exception e) {
            return null;
        }
    }

    public PicList getPicList(String url) {
        try {
            PicList picList = new PicList();
            Document doc = Jsoup.connect(url).get();
            Elements imgs = doc.select("ul.file > img[src]");
            for (Element element : imgs) {
                picList.addPicDetail(CrawlerUtils.getUrl(url, element.attr("src")));
            }
            Elements els = doc.select("ul.image > a:contains(下一页)");
            if (els != null && els.size() > 0) {
                picList.setNextPageUrl(CrawlerUtils.getUrl(url, els.get(0).attr("href")));
            } else {
                picList.setNextPageUrl("");
            }
            return picList;
        } catch (Exception e) {
            return null;
        }
    }

}
