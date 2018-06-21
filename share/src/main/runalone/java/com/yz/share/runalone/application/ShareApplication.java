package com.yz.share.runalone.application;

//import com.luojilab.component.basicres.BaseApplication;
//import com.luojilab.component.componentlib.router.Router;

import android.app.Application;

/**
 * Created by mrzhang on 2017/6/20.
 */

public class ShareApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //如果isRegisterCompoAuto为false，则需要通过反射加载组件
//        Router.registerComponent("com.luojilab.share.applike.ShareApplike");
//        Router.registerComponent("com.luojilab.share.kotlin.applike.KotlinApplike");
    }

}
