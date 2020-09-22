package com.example.aicarapplication.pojo;

public class ContentBean {
    private int contentImage;
    private String contentTitle;
    private String content;

    public ContentBean() {
    }

    public ContentBean(int contentImage, String contentTitle, String content) {
        this.contentImage = contentImage;
        this.contentTitle = contentTitle;
        this.content = content;
    }

    public int getContentImage() {
        return contentImage;
    }

    public void setContentImage(int contentImage) {
        this.contentImage = contentImage;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
