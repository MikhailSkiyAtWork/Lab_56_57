package com.example.admin.lab_56_57;

/**
 * Created by Mikhail Valuyskiy on 21.05.2015.
 */

/**
 * Utility class
 */
public class Utility {

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
     * @param version
     * @param size
     * @return
     */
    public static String makeDescription(int version,double size){
        String description ="Version " + version + "Size: " + size;
        return description;
    }



}
