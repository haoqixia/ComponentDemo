package com.yz.bdmap;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by mrzhang on 2017/6/15.
 */

public class BdMapAppLike   {


    public static void onCreate(Application application) {
        //初始化百度地图
        SDKInitializer.initialize(application);
    }

    public static void onStop(Application application) {

    }
}
