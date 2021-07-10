package com.example.myappislami;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash_Icon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash_icon);
        int secondDelayed = 2;
        new Handler().postDelayed(new Runnable() {

            public void run() {
                startActivity(new Intent(Splash_Icon.this,MainActivity.class));

        finish();}

    },
             secondDelayed * 1000);


       // final ImageView imageView = (ImageView)findViewById(R.id.imageView);
        RotateAnimation anim = new RotateAnimation(0f, 350f, 15f, 15f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(7000);

// Start animating the image
        final ImageView splash = (ImageView) findViewById(R.id.imageView);
        splash.startAnimation(anim);

// Later.. stop the animation
        splash.setAnimation(null);

    }
}