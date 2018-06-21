package com.yz.componentdemo.application;

import com.luojilab.component.componentlib.router.Router;
import com.yz.basicres.BaseApplication;
import com.luojilab.component.componentlib.router.ui.UIRouter;

/**
 * Created by mrzhang on 2017/6/15.
 */

public class AppApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        UIRouter.getInstance().registerUI("app");

        //如果isRegisterCompoAuto为false，则需要通过反射加载组件
//        Router.registerComponent("com.yz.reader.applike.ReaderAppLike");
//        Router.registerComponent("com.yz.share.applike.ShareApplike");
    }


}
