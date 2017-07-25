package com.pankaj.simplegesturelistener;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by APPZLOGIC on 7/25/2017.
 */

public class SimpleGestures implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private View view;
    private GesturesListener swipeListener;
    private GestureDetectorCompat detector ;
    private Context context;

    private int swipe_Min_Distance = 100;
    private int swipe_Max_Distance = 750;
    private int swipe_Min_Velocity = 100;


    public SimpleGestures(Context context, View view) {
        this.view = view;
        this.context = context;
        this.detector = new GestureDetectorCompat(context,this);
        this.view.setLongClickable(true);
        this.view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.setIsLongpressEnabled(true);
                detector.onTouchEvent(motionEvent);
                return false;
            }
        });
    }

    public int getSwipe_Min_Distance() {
        return swipe_Min_Distance;
    }

    public void setSwipe_Min_Distance(int swipe_Min_Distance) {
        this.swipe_Min_Distance = swipe_Min_Distance;
    }

    public int getSwipe_Max_Distance() {
        return swipe_Max_Distance;
    }

    public void setSwipe_Max_Distance(int swipe_Max_Distance) {
        this.swipe_Max_Distance = swipe_Max_Distance;
    }

    public int getSwipe_Min_Velocity() {
        return swipe_Min_Velocity;
    }

    public void setSwipe_Min_Velocity(int swipe_Min_Velocity) {
        this.swipe_Min_Velocity = swipe_Min_Velocity;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        swipeListener.onLongPress(view);

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        final float xDistance = Math.abs(motionEvent.getX() - motionEvent1.getX());
        final float yDistance = Math.abs(motionEvent.getY() - motionEvent1.getY());
        if(xDistance > this.swipe_Max_Distance || yDistance > this.swipe_Max_Distance)
            return false;
        v = Math.abs(v);
        v1 = Math.abs(v1);

        if(v > this.swipe_Min_Velocity && xDistance > this.swipe_Min_Distance){
            if(motionEvent.getX() > motionEvent1.getX()) // right to left
                 swipeListener.onSwipeLeft(view);
            else
                swipeListener.onSwipeRight(view);
        } else if(v1 > this.swipe_Min_Velocity && yDistance > this.swipe_Min_Distance) {
            if (motionEvent.getY() > motionEvent1.getY())
                swipeListener.onSwipeTop(view);
            else
                swipeListener.onSwipeBottom(view);
        }
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        swipeListener.onDoubleTap(view);
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public interface GesturesListener{
        void onSwipeLeft(View view);
        void onSwipeRight(View view);
        void onSwipeTop(View view);
        void onSwipeBottom(View view);
        void onDoubleTap(View view);
        void onLongPress(View view);
    }

    public void setOnGesturesListener(GesturesListener swipeListener){
        this.swipeListener = swipeListener;
    }
}
