package com.yz.reader.serviceimpl;

import android.support.v4.app.Fragment;

import com.yz.comservice.readerbook.ReadBookService;
import com.yz.reader.ReaderFragment;

/**
 * Created by mrzhang on 2017/6/15.
 */

public class ReadBookServiceImpl implements ReadBookService {
    @Override
    public Fragment getReadBookFragment() {
        return new ReaderFragment();
    }
}
