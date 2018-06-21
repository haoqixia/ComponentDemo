package com.yz.componentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.luojilab.component.componentlib.router.Router;
import com.luojilab.router.facade.annotation.RouteNode;
import com.yz.basicres.BaseActivity;
import com.yz.basicres.BaseApplication;
import com.yz.comservice.readerbook.ReadBookService;

@RouteNode(path = "/main", desc = "首页")
public class MainActivity extends BaseActivity implements View.OnClickListener{
    Fragment fragment;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button installReadBookBtn = (Button) findViewById(R.id.install_share);
        Button uninstallReadBtn = (Button) findViewById(R.id.uninstall_share);
        installReadBookBtn.setOnClickListener(this);
        uninstallReadBtn.setOnClickListener(this);
        showFragment();
    }

    private void showFragment() {
        if (fragment != null) {
            ft = getSupportFragmentManager().beginTransaction();
            ft.remove(fragment).commit();
            fragment = null;
        }
        Router router = Router.getInstance();
        if (router.getService(ReadBookService.class.getSimpleName()) != null) {
            ReadBookService service = (ReadBookService) router.getService(ReadBookService.class.getSimpleName());
            fragment = service.getReadBookFragment();
            ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.tab_content, fragment).commitAllowingStateLoss();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.install_share:
                Router.registerComponent("com.yz.share.applike.ShareApplike",getApplication());
                break;
            case R.id.uninstall_share:
                Router.unregisterComponent("com.yz.share.applike.ShareApplike",getApplication());
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Toast.makeText(BaseApplication.getAppContext(), data.getStringExtra("result"),Toast.LENGTH_SHORT).show();
        }
    }
}
