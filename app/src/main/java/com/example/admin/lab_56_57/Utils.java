package com.example.admin.lab_56_57;

/**
 * Created by Mikhail Valuyskiy on 21.05.2015.
 */

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.File;

/**
 * Utils class
 */
public class Utils {

    public static final String TAG = "ERROR";

    /**
     * Checks is it second item or not
     *
     * @param position The position of item in ListView
     * @return If it is second image returns true, otherwise false
     */
    public static boolean isItSecondItem(int position) {
        if ((position + 1) % 2 == 0) {
            return true;
        } else return false;
    }

    /**
     * Checks is it third item or not
     *
     * @param position The position of item in ListView
     * @return If it is third image returns true, otherwise false
     */
    public static boolean isItThirdItem(int position) {
        if ((position + 1) % 3 == 0) {
            return true;
        } else return false;
    }

    /**
     * Creates description for app
     */
    public static String makeDescription(int version, double size) {
        String description = "Version " + version + "Size: " + size;
        return description;
    }

    /**
     * Get icon
     */
    public static Drawable getIcon(PackageManager packageManager, ApplicationInfo packageInfo) {
        // Getting icon of app
        Drawable icon = packageInfo.loadIcon(packageManager);
        return icon;
    }

    /**
     * Get size of app
     */
    public static double getSize(PackageManager packageManager, ApplicationInfo packageInfo) {
        double size = 0;
        try {
            File file = new File(packageInfo.sourceDir);
            size = file.length();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return size;
    }

}
