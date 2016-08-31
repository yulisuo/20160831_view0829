package com.yls.view.view0829;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by yulisuo on 16-8-29.
 */
public class MyView extends View {

    GestureDetector gd;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    private void init() {
        Log.i(Utils.TAG,"my view init");
        gd = new GestureDetector(getContext(),new MyGestureListener(R.id.my_view,""));
        gd.setIsLongpressEnabled(false);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


}
