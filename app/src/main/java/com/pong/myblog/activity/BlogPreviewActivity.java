package com.pong.myblog.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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

        setupToolbar();

        if(savedInstanceState == null){
            showBlogPreviewFragment();
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
//            actionBar.setDisplayShowTitleEnabled(false);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_blog_preview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_blogpreview_edit) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
