package com.example.aicarapplication.pojo;

public class ContentBean {
   private String ItemName;
   private Integer itemImage;
   private String itemContent;

    public ContentBean(String itemName, Integer itemImage, String itemContent) {
        ItemName = itemName;
        this.itemImage = itemImage;
        this.itemContent = itemContent;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public ContentBean(String itemName, Integer itemImage) {
        ItemName = itemName;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public Integer getItemImage() {
        return itemImage;
    }

    public void setItemImage(Integer itemImage) {
        this.itemImage = itemImage;
    }
}
