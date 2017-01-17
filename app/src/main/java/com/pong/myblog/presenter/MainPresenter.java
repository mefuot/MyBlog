package com.pong.myblog.presenter;

import android.content.Context;

import com.pong.myblog.contract.MainContract;
import com.pong.myblog.database.BlogDbHelper;
import com.pong.myblog.model.BlogModel;

import java.util.List;

/**
 * Created by USER on 17/1/2560.
 */

public class MainPresenter implements MainContract.MainPresenter {
    private MainContract.MainView view;

    public MainPresenter(MainContract.MainView view) {
        this.view = view;
    }

    @Override
    public void loadAllBlog(Context context) {
        BlogDbHelper db = new BlogDbHelper(context);
        List<BlogModel> list = db.getAllBlog();
        view.updateBlogList(list);
    }
}
