package com.imlzq.rxbus.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by lizhongquan on 2017/2/24.
 */

public class Utils {

    /**
     * Check object is null or not
     * If null, throw an exception
     *
     * @param object T
     * @param msg    The error message
     * @param <T>    T
     * @return T
     */
    public static <T> T checkNotNull(T object, String msg) {
        if (object == null) {
            if (msg == null) {
                throw new NullPointerException("checkNotNull is null");
            } else {
                throw new NullPointerException(msg);
            }
        }

        return object;
    }

    /**
     * Check object is null or not
     * If null, throw an exception
     *
     * @param object T
     * @param <T>    T
     * @return T
     */
    public static <T> T checkNotNull(T object) {
        if (object == null) {
            throw new NullPointerException("CheckNotNull is null");
        }

        return object;
    }

    /**
     * Use specific fragment to replace the specific widget
     *
     * @param fragmentManager android.support.v4.FragmentManager
     * @param fragment        android.support.v4.Fragment
     * @param frameId         container
     */
    public static void addFragmentToActivity(FragmentManager fragmentManager,
                                             Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);

        fragmentManager.beginTransaction().add(frameId, fragment).commit();
    }

    /**
     * Use specific fragment to replace the specific widget
     *
     * @param fragmentManager android.app.FragmentManager
     * @param fragment        android.app.Fragment
     * @param frameId         container
     */
    public static void addFragmentToActivity(android.app.FragmentManager fragmentManager,
                                             android.app.Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);

        fragmentManager.beginTransaction().add(frameId, fragment).commit();
    }
}
