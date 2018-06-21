package com.luojilab.component.componentlib.applicationlike;

import android.app.Application;

/**
 * Created by mrzhang on 2017/6/15.
 */

public interface IApplicationLike {

    void onCreate(Application application);

    void onStop(Application application);

}
