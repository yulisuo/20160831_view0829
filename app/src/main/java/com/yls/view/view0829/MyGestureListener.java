package com.yls.view.view0829;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by yulisuo on 16-8-29.
 */
public class MyGestureListener implements GestureDetector.OnGestureListener {

    private int viewId;
    private String viewName;

    public MyGestureListener(int id,String name){
        viewId = id;
        viewName = name;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
