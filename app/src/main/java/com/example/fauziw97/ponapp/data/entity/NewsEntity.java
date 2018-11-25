package com.example.fauziw97.ponapp.data.entity;

public class NewsEntity {
    private String newsImage;
    private String newsTitle;
    private int newsDate;
    private String newsDesc;

    public NewsEntity() {

    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }



    public String getNewsDesc() {
        return newsDesc;
    }

    public void setNewsDesc(String newsDesc) {
        this.newsDesc = newsDesc;
    }

    public int getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(int newsDate) {
        this.newsDate = newsDate;
    }


}
