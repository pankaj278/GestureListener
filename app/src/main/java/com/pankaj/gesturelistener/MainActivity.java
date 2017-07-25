package com.pankaj.gesturelistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.pankaj.simplegesturelistener.SimpleGestures;

public class MainActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (ImageView) findViewById(R.id.view);

        new SimpleGestures(this,view).setOnGesturesListener(new SimpleGestures.GesturesListener() {
            @Override
            public void onSwipeLeft(View view) {
                Toast.makeText(MainActivity.this, "Swipe Left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipeRight(View view) {
                Toast.makeText(MainActivity.this, "Swipe Right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipeTop(View view) {
                Toast.makeText(MainActivity.this, "Swipe Top", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSwipeBottom(View view) {
                Toast.makeText(MainActivity.this, "Swipe Bottom", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDoubleTap(View view) {
                Toast.makeText(MainActivity.this, "Double Tap", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongPress(View view) {
                Toast.makeText(MainActivity.this, "Long Press", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
