package com.yls.view.view0829;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvRet;
    Button btn1;
    MyView myView;
    StringBuffer sb;
    GestureDetector gd;

    private static final Boolean FLAG_VELOCITYTRACKER = false;
    private static final Boolean FLAG_GESTUREDETECTOR = false;
    private static final Boolean FLAG_GESTUREDETECTOR_MYVIEW = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tvRet = (TextView) findViewById(R.id.ret);
        btn1 = (Button) findViewById(R.id.btn1);
        myView = (MyView) findViewById(R.id.my_view);
        sb = new StringBuffer();

        if (FLAG_GESTUREDETECTOR) {
            gd = new GestureDetector(MainActivity.this, new MyGestureListener(R.id.btn1,"button1"));
            //解决长按屏幕后无法拖动的现象
            gd.setIsLongpressEnabled(false);
            btn1.setOnTouchListener(new MyTouchListener());
        }
        if (FLAG_GESTUREDETECTOR_MYVIEW) {
            gd = new GestureDetector(MainActivity.this, new MyGestureListener(R.id.my_view,"myview"));
            //解决长按屏幕后无法拖动的现象
            gd.setIsLongpressEnabled(false);
        }
    }


    class MyTouchListener implements View.OnTouchListener{

        boolean consume;
        @Override
        public boolean onTouch(View v, MotionEvent event){
            switch (v.getId()){
                case R.id.btn1:
                    Log.d(Utils.TAG,"button 1 on touch listener");
                    if(gd != null){
                        consume = gd.onTouchEvent(event);
                    }
                    break;
                default:
                    break;
            }
            return consume;
        }
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        //速度追踪
//        Log.i(Utils.TAG,"MotionEvent action:"+getActionString(event.getAction()));
//        if(FLAG_VELOCITYTRACKER && event.getAction() == MotionEvent.ACTION_MOVE){
//            VelocityTracker vt = VelocityTracker.obtain();
//            vt.addMovement(event);
//            vt.computeCurrentVelocity(1000);
//            float xV = vt.getXVelocity();
//            float xY = vt.getYVelocity();
//            Log.i(Utils.TAG,"MotionEvent VelocityTracker:"+"xV:"+xV+",xY:"+xY);
//            tvRet.setText("xV:"+xV+",xY:"+xY);
//        }
//
//        return super.onTouchEvent(event);
//    }
//
//    private String getActionString(int action) {
//        switch (action){
//            case MotionEvent.ACTION_DOWN:
//                return "ACTION_DOWN";
//            case MotionEvent.ACTION_UP:
//                return "ACTION_UP";
//            case MotionEvent.ACTION_CANCEL:
//                return "ACTION_CANCEL";
//            case MotionEvent.ACTION_MOVE:
//                return "ACTION_MOVE";
//            default:
//                return "get no action";
//        }
//    }
}
