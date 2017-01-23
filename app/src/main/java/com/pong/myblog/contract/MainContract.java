package com.pong.myblog.contract;

import android.content.Context;

import com.pong.myblog.model.BlogModel;

import java.util.List;

/**
 * Created by USER on 17/1/2560.
 */

public interface MainContract {
    interface MainView{
        void updateBlogList(List<BlogModel> list);
        void gotoAddNewBlogPage();
        void gotoBlogPreviewPage(int blogId);
    }
    interface MainPresenter{
        void loadAllBlog(Context context);
    }
}
