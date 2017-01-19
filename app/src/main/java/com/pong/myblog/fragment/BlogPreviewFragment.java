package com.pong.myblog.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.pong.myblog.R;
import com.pong.myblog.contract.BlogPreviewContract;
import com.pong.myblog.model.BlogModel;
import com.pong.myblog.presenter.BlogPreviewPresenter;

/**
 * Created by USER on 19/1/2560.
 */

public class BlogPreviewFragment extends Fragment implements BlogPreviewContract.BlogPreviewView {
    private BlogPreviewPresenter presenter;
    private TextView textTitle;
    private TextView textDate;
    private WebView webContent;

    private int blogId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        blogId = getArguments().getInt("blogId");
        return inflater.inflate(R.layout.fragment_blog_preview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textTitle = (TextView) view.findViewById(R.id.textview_blogpreview_title);
        textDate = (TextView) view.findViewById(R.id.textview_blogpreview_date);
        webContent = (WebView) view.findViewById(R.id.webview_blogpreview_content);


        presenter = new BlogPreviewPresenter(this);
        presenter.loadBlogData(getActivity(),blogId);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void updateBlogData(BlogModel blog) {
        getActivity().setTitle(blog.getTitle());
        textTitle.setText(blog.getTitle());
        textDate.setText(blog.getDate());
        webContent.getSettings().setJavaScriptEnabled(true);
        webContent.loadData(blog.getContent(), "text/html; charset=utf-8", "UTF-8");
    }

    @Override
    public void goToBlogEditPage(int blogId) {

    }
}
