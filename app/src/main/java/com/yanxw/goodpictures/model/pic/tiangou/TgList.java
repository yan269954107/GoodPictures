package com.yanxw.goodpictures.model.pic.tiangou;

import com.yanxw.goodpictures.adapter.PicListAdapter;
import com.yanxw.goodpictures.api.pic.tiangou.TianGouService;

import java.util.List;

/**
 * Created by yanxinwei on 16/8/4.
 */

public class TgList {


    /**
     * status : true
     * total : 270
     * tngou : [{"count":58,"fcount":0,"galleryclass":1,"id":860,"img":"/ext/160803/dc8b88ad4fddcf2a9e35d43fe3e3a504.jpg",
     * "rcount":0,"size":8,"time":1470224415000,"title":"性感女神绮里嘉Ula制服学生妹极致魅惑诱人"}]
     */

    private boolean status;
    private int total;
    /**
     * count : 58
     * fcount : 0
     * galleryclass : 1
     * id : 860
     * img : /ext/160803/dc8b88ad4fddcf2a9e35d43fe3e3a504.jpg
     * rcount : 0
     * size : 8
     * time : 1470224415000
     * title : 性感女神绮里嘉Ula制服学生妹极致魅惑诱人
     */

    private List<PicturesInfo> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<PicturesInfo> getTngou() {
        return tngou;
    }

    public void setTngou(List<PicturesInfo> tngou) {
        this.tngou = tngou;
    }

    public static class PicturesInfo {
        private int count;
        private int fcount;
        private int galleryclass;
        private int id;
        private String img;
        private int rcount;
        private int size;
        private long time;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getFcount() {
            return fcount;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public int getGalleryclass() {
            return galleryclass;
        }

        public void setGalleryclass(int galleryclass) {
            this.galleryclass = galleryclass;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return TianGouService.TIANGOU_IMG_BASE + img;
        }

        public String getThumbnailsUrl() {
            return getUrl() + "_" + PicListAdapter.THUMBNAILS_WIDTH;
        }
    }
}
