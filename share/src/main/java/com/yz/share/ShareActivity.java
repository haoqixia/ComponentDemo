package com.yz.share;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.luojilab.component.componentlib.service.AutowiredService;
import com.luojilab.router.facade.annotation.Autowired;
import com.luojilab.router.facade.annotation.RouteNode;
import com.yz.basicres.BaseActivity;
import com.yz.comservice.readerbook.bean.Author;

@RouteNode(path = "/shareBook", desc = "分享书籍页面")
public class ShareActivity extends BaseActivity {


    @Autowired
    String bookName;

    @Autowired
    Author author;

    private TextView tvShareTitle;
    private TextView tvShareBook;
    private TextView tvAuthor;
    private TextView tvCounty;

    private final static int RESULT_CODE = 8888;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AutowiredService.Factory.getInstance().create().autowire(this);
        setContentView(R.layout.activity_share);

        tvShareTitle =  findViewById(R.id.share_title);
        tvShareBook = findViewById(R.id.share_tv_tag);
        tvAuthor =  findViewById(R.id.share_tv_author);
        tvCounty =  findViewById(R.id.share_tv_county);

        tvShareTitle.setText("Book");

        if (bookName != null) {
            tvShareBook.setText(bookName);
        }

        if (author != null) {
            tvAuthor.setText(author.getName());
            tvCounty.setText(author.getCounty());
        }

        Intent intent = new Intent();
        intent.putExtra("result", "Share Success");
        setResult(RESULT_CODE, intent);

    }

}
