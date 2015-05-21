package com.example.admin.lab_56_57.data;

import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.telephony.SignalStrength;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Mikhail Valuyskiy on 21.05.2015.
 */

/**
 * Describes different information about app
 */
public class AppInfo {
    public String appname;
    public int targetSdkVersion;
    public double size;
    public Drawable icon;

    public AppInfo(String appname, int version, double size,Drawable icon) {
        this.appname = appname;
        this.targetSdkVersion = version;
        this.size = size;
        this.icon = icon;
    }

}


