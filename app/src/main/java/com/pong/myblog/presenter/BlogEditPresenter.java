package com.pong.myblog.presenter;

import android.content.Context;

import com.pong.myblog.contract.BlogEditContract;
import com.pong.myblog.database.BlogDbHelper;
import com.pong.myblog.model.BlogModel;

/**
 * Created by USER on 23/1/2560.
 */

public class BlogEditPresenter implements BlogEditContract.BlogEditPresenter {
    private BlogEditContract.BlogEditView view;
    private BlogDbHelper db;

    public BlogEditPresenter(Context context, BlogEditContract.BlogEditView view) {
        this.view = view;
        db = new BlogDbHelper(context);
    }

    @Override
    public void loadBlogData(int blogId) {
        BlogModel blog = db.getBlogById(blogId);
        view.onExistBlogDataLoaded(blog);
    }

    @Override
    public void insertNewBlog(BlogModel blog) {
        db.insertBlog(blog);
        view.onNewBlogAdded();
    }

    @Override
    public void editExistBlogData(int blogId, BlogModel blog) {
        db.updateBlog(blogId, blog);
        view.onModifiedBlogData();
    }

    @Override
    public void closeDb() {
        if (db != null) db.close();
    }
}
