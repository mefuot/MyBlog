package com.pong.myblog.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * Created by USER on 19/1/2560.
 */

public class NonClickableWebView extends WebView {
    public NonClickableWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setClickable(false);
        setLongClickable(false);
        setFocusable(false);
        setFocusableInTouchMode(false);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return false;
    }
}