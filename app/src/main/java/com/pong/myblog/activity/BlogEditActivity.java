package com.pong.myblog.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pong.myblog.R;
import com.pong.myblog.fragment.BlogEditFragment;
import com.pong.myblog.listener.OnBlogEditFragmentListener;

/**
 * Created by USER on 10/1/2560.
 */

public class BlogEditActivity extends AppCompatActivity implements OnBlogEditFragmentListener {
    private BlogEditFragment fragment;
    private int blogId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        setupToolbar();
        blogId = getIntent().getIntExtra("blogId",-1);

        if(savedInstanceState == null){
            showBlogEditFragment();
        }
    }

    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void showBlogEditFragment(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        fragment = new BlogEditFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("blogId", blogId);
        fragment.setArguments(bundle);
        ft.add(R.id.container, fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public void onBlogEdited() {
        finish();
    }
}
