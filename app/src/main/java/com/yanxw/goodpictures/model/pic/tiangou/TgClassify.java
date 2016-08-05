package com.yanxw.goodpictures.model.pic.tiangou;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yanxinwei on 16/8/3.
 */

public class TgClassify implements Serializable{


    /**
     * status : true
     * tngou : [{"description":"性感美女","id":1,"keywords":"性感美女","name":"性感美女","seq":1,"title":"性感美女"},
     * {"description":"韩日美女","id":2,"keywords":"韩日美女","name":"韩日美女","seq":2,"title":"韩日美女"}]
     */

    private boolean status;
    /**
     * description : 性感美女
     * id : 1
     * keywords : 性感美女
     * name : 性感美女
     * seq : 1
     * title : 性感美女
     */

    private List<Classify> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Classify> getTngou() {
        return tngou;
    }

    public void setTngou(List<Classify> tngou) {
        this.tngou = tngou;
    }

    public static class Classify implements Serializable{
        private String description;
        private int id;
        private String keywords;
        private String name;
        private int seq;
        private String title;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Classify{" +
                    "description='" + description + '\'' +
                    ", id=" + id +
                    ", keywords='" + keywords + '\'' +
                    ", name='" + name + '\'' +
                    ", seq=" + seq +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Classify bean : tngou) {
            sb.append(bean.toString());
            sb.append("\r\n");
        }
        return sb.toString();
    }
}
