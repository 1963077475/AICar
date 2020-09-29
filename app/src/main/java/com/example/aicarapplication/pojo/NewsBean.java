package com.example.aicarapplication.pojo;

public class NewsBean {
    private String newTitle;
    private String newsContent;
    private Integer newImage;

    public NewsBean(String newTitle, String newsContent, Integer newImage) {
        this.newTitle = newTitle;
        this.newsContent = newsContent;
        this.newImage = newImage;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public Integer getNewImage() {
        return newImage;
    }

    public void setNewImage(Integer newImage) {
        this.newImage = newImage;
    }
}
