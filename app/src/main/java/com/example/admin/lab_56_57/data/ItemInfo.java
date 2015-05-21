package com.example.admin.lab_56_57.data;

/**
 * Created by Mikhail Valuyskiy on 21.05.2015.
 */

/**
 * Represent the item in the ListView
 */
public class ItemInfo {
    public int imageId;
    public String title;
    public String description;

    public ItemInfo(String title, String description){
        this.title = title;
        this.description = description;
    }

    public ItemInfo(int imageId,String title, String description){
        this.imageId = imageId;
        this.title = title;
        this.description = description;
    }
}
