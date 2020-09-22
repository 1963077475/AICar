package com.example.aicarapplication.pojo;

public class ItemBean {
    private String itemName;
    private int itemImage;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "itemName='" + itemName + '\'' +
                ", itemImage=" + itemImage +
                '}';
    }
}
