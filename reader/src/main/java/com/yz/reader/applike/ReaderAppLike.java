package com.yz.reader.applike;
import android.app.Application;

import com.luojilab.component.componentlib.applicationlike.IApplicationLike;
import com.luojilab.component.componentlib.router.Router;
import com.luojilab.component.componentlib.router.ui.UIRouter;

import com.yz.bdmap.BdMapAppLike;
import com.yz.comservice.readerbook.ReadBookService;
import com.yz.reader.serviceimpl.ReadBookServiceImpl;

/**
 * Created by mrzhang on 2017/6/15.
 */

public class ReaderAppLike implements IApplicationLike {

    Router router = Router.getInstance();
    UIRouter uiRouter = UIRouter.getInstance();

    @Override
    public void onCreate(Application application) {
        uiRouter.registerUI("reader");
        router.addService(ReadBookService.class.getSimpleName(), new ReadBookServiceImpl());
//        router.addService(ReadBookService.class.getSimpleName(), new ReadBookServiceImplKotlin());
        BdMapAppLike.onCreate(application);
    }

    @Override
    public void onStop(Application application) {
        uiRouter.unregisterUI("reader");
        router.removeService(ReadBookService.class.getSimpleName());
    }
}
