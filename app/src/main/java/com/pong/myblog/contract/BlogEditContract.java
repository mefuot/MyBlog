package com.pong.myblog.contract;

import android.content.Context;

import com.pong.myblog.model.BlogModel;

/**
 * Created by USER on 23/1/2560.
 */

public interface BlogEditContract {
    interface BlogEditView{
        void onExistBlogDataLoaded(BlogModel blog);
        void onNewBlogAdded();
        void onModifiedBlogData();
    }
    interface BlogEditPresenter{
        void loadBlogData(int blogId);
        void insertNewBlog(BlogModel blog);
        void editExistBlogData(int blogId,BlogModel blog);
        void closeDb();
    }
}
