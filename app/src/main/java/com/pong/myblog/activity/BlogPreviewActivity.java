package com.pong.myblog.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.pong.myblog.R;
import com.pong.myblog.fragment.BlogPreviewFragment;

/**
 * Created by USER on 19/1/2560.
 */

public class BlogPreviewActivity extends AppCompatActivity {
    BlogPreviewFragment fragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        if(savedInstanceState == null){
            showBlogPreviewFragment();
        }
    }

    private void showBlogPreviewFragment(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        fragment = new BlogPreviewFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("blogId", getIntent().getIntExtra("blogId",-1));
        fragment.setArguments(bundle);
        ft.add(R.id.container, fragment);
        ft.commit();
    }
}
