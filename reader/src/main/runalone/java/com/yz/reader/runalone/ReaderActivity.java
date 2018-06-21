package com.yz.reader.runalone;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yz.basicres.BaseActivity;
import com.yz.reader.R;
import com.yz.reader.ReaderFragment;

public class ReaderActivity extends BaseActivity {

    ReaderFragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);
        fragment = new ReaderFragment();
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.tab_content, fragment).commitAllowingStateLoss();
    }
}
