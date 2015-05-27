package com.example.admin.lab_56_57.data;

/**
 * Created by Mikhail Valuyskiy on 21.05.2015.
 */

/**
 * Represent the item in the ListView
 */
public class ItemInfo {
    private String title_;
    private String description_;
    private int imageId_;

    public ItemInfo(int imageId, String title, String description) {
        this.imageId_ = imageId;
        this.title_ = title;
        this.description_ = description;
    }

    public String getTitle_() {
        return title_;
    }

    public String getDescription_() {
        return description_;
    }

    public int getImageId_() {
        return imageId_;
    }

    public ItemInfo(String title, String description) {
        this.title_ = title;
        this.description_ = description;
    }
}
