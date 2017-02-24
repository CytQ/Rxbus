package com.imlzq.rxbus.data;

/**
 * Created by lizhongquan on 2017/2/24.
 */

public class DataManager {

    private DataManager(){}

    public static DataManager getInstance(){
        return DataManagerHolder.instance;
    }

    private static class DataManagerHolder {
        final static DataManager instance = new DataManager();
    }
}
