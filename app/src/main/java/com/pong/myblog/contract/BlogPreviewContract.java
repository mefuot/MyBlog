package com.pong.myblog.contract;

import android.content.Context;

import com.pong.myblog.model.BlogModel;

import java.util.List;

/**
 * Created by USER on 19/1/2560.
 */

public interface BlogPreviewContract {
    interface BlogPreviewView{
        void updateBlogData(BlogModel blog);
        void goToBlogEditPage(int blogId);
    }
    interface BlogPreviewPresenter{
        void loadBlogData(Context context,int blogId);
    }
}
