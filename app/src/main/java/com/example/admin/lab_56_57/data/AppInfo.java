package com.example.admin.lab_56_57.data;

import android.graphics.drawable.Drawable;

/**
 * Created by Mikhail Valuyskiy on 21.05.2015.
 */

/**
 * Describes different information about app
 */
public class AppInfo {
    private String title_;
    private int targetSdkVersion_;
    private double size_;
    private Drawable icon_;

    public AppInfo(String appname, int version, double size, Drawable icon) {
        this.title_ = appname;
        this.targetSdkVersion_ = version;
        this.size_ = size;
        this.icon_ = icon;
    }

    public String getTitle_() {
        return title_;
    }

    public int getTargetSdkVersion_() {
        return targetSdkVersion_;
    }

    public double getSize_() {
        return size_;
    }

    public Drawable getIcon_() {
        return icon_;
    }
}


