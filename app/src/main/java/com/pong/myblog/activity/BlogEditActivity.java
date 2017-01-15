package com.pong.myblog.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.pong.myblog.R;
import com.pong.myblog.fragment.BlogEditFragment;
import com.pong.myblog.listener.OnBlogEditFragmentListener;

/**
 * Created by USER on 10/1/2560.
 */

public class BlogEditActivity extends AppCompatActivity implements OnBlogEditFragmentListener {
    private BlogEditFragment blogEditFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        if(savedInstanceState == null){
            showBlogEditFragment();
        }

    }

    private void showBlogEditFragment(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        blogEditFragment = new BlogEditFragment();
        ft.add(R.id.container, blogEditFragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onAddedNewBlog() {
        finish();
    }
}
