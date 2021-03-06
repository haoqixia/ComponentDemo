package com.yz.share.applike;

import android.app.Application;

import com.luojilab.component.componentlib.applicationlike.IApplicationLike;
import com.luojilab.component.componentlib.router.ui.UIRouter;

/**
 * Created by mrzhang on 2017/6/15.
 */

public class ShareApplike implements IApplicationLike {

    UIRouter uiRouter = UIRouter.getInstance();

    @Override
    public void onCreate(Application application) {
        uiRouter.registerUI("share");
    }

    @Override
    public void onStop(Application application) {
        uiRouter.unregisterUI("share");
    }
}
