package com.example.admin.lab_56_57;

/**
 * Created by Mikhail Valuyskiy on 21.05.2015.
 */

/**
 * Utility class
 */
public class Utility {

    /**
     * Checks is it second image or not
     * @param position The position of image in ListView
     * @return If it is second image returns true, otherwise false
     */
    public static boolean isItSecondImage(int position){
        if ((position + 1)%2 == 0){
            return true;
        }
        else return false;
    }

    /**
     * Checks is it third image or not
     * @param position The position of image in ListView
     * @return If it is third image returns true, otherwise false
     */
    public static boolean isItThirdImage(int position){
        if ((position + 1) % 3 == 0) {
            return true;
        }
        else return false;
    }

    /**
     * Checks is it fourth image or not
     * @param position The position of image in ListView
     * @return If it is fourth image returns true, otherwise false
     */
    public static boolean isItFourthImage(int position){
        if ((position + 1) % 4 == 0) {
            return true;
        }
        else return false;
    }
}
