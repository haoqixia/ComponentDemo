package com.yz.reader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luojilab.component.componentlib.router.ui.UIRouter;
import com.luojilab.component.componentlib.service.JsonService;
import com.yz.comservice.readerbook.bean.Author;

/**
 * Created by yuanzhuang on 2018/4/16.
 */

public class ReaderFragment extends Fragment {
    private View rootView;
    private final static int REQUEST_CODE = 7777;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_reader, container, false);

            rootView.findViewById(R.id.tv_1).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    goToShareActivityWithBundle();
                }
            });
            rootView.findViewById(R.id.tv_2).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
//                    goToShareActivityWithUri();
                }
            });
            rootView.findViewById(R.id.tv_3).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    goToShareActivityForResult();
                }
            });
        }
        return rootView;
    }

    // UI transfer with Bundle
    private void goToShareActivityWithBundle() {
        Author author = new Author();
        author.setName("Margaret Mitchell");
        author.setCounty("USA");
        Bundle bundle = new Bundle();
        bundle.putString("bookName", "Gone with the Wind");
        bundle.putString("author", JsonService.Factory.getInstance().create().toJsonString(author));
        UIRouter.getInstance().openUri(getActivity(), "DDComp://share/shareBook", bundle);
    }

    // UI transfer with URI
    //user kotlin data class
//    private void goToShareActivityWithUri() {
//        AuthorKt author = new AuthorKt("Barack Obama", 65, "New York");
//        UIRouter.getInstance().openUri(getActivity(),
//                "DDComp://kotlin/shareMagazine?bookName=NYTIME&author="
//                        + JsonService.Factory.getInstance().create().toJsonString(author), null);
//    }


    //startActivityForResult
    private void goToShareActivityForResult() {
        Author author = new Author();
        author.setName("Margaret Mitchell");
        author.setCounty("USA");
        UIRouter.getInstance().openUri(getActivity(),
                "DDComp://share/shareBook?bookName=Gone with the Wind&author="
                        + JsonService.Factory.getInstance().create().toJsonString(author), null, REQUEST_CODE);
    }

}
