package com.vikdev.truthdare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private ImageView mImageView;
    private Random mRandom = new Random();
    private int lastDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);
        mImageView = findViewById(R.id.imageView);

    }

    public void spin(View view) {
        int newDirection = mRandom.nextInt(3600 - 360) + 360;
        if (newDirection > 180) {
            newDirection += 360;
        }

        float pivotX = mImageView.getWidth() / 2;
        float pivotY = mImageView.getHeight() / 2;

        Animation rotate = new RotateAnimation(lastDirection, newDirection, pivotX, pivotY);
        rotate.setDuration(1000);
        rotate.setFillAfter(true);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mButton.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mButton.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        lastDirection = newDirection;

        mImageView.startAnimation(rotate);

    }
}
