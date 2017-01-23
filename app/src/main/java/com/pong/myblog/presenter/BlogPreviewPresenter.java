package com.pong.myblog.presenter;


import android.content.Context;

import com.pong.myblog.contract.BlogPreviewContract;
import com.pong.myblog.database.BlogDbHelper;
import com.pong.myblog.model.BlogModel;

/**
 * Created by USER on 19/1/2560.
 */

public class BlogPreviewPresenter implements BlogPreviewContract.BlogPreviewPresenter {
    private BlogPreviewContract.BlogPreviewView view;

    public BlogPreviewPresenter(BlogPreviewContract.BlogPreviewView view) {
        this.view = view;
    }

    @Override
    public void loadBlogData(Context context,int blogId) {
        BlogDbHelper db = new BlogDbHelper(context);
        BlogModel blog = db.getBlogById(blogId);
        view.updateBlogData(blog);
    }
}
