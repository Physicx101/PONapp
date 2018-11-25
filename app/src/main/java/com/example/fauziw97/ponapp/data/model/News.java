package com.example.fauziw97.ponapp.data.model;

public class News {
    private String newsImage;
    private String newsTitle;
    private int newsDate;
    private String newsDesc;

    public News() {

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


    public void setNewsDesc(String newsDesc) {
        this.newsDesc = newsDesc;
    }

    public void setNewsDate(int newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsDesc() {
        return newsDesc;
    }

    public int getNewsDate() {
        return newsDate;
    }

}
