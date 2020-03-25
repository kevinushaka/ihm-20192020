package com.example.demoihm_lift;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

public class Lift {

    private final static int  OFFSET=2;
    private LevelSensor levelSensor;
    private int currentPosition;
    Lift(LevelSensor levelSensor){
        this.levelSensor=levelSensor;
        this.currentPosition=0;
    }

    void move(View liftCabin,final int positionOrder) {
        ObjectAnimator animator=ObjectAnimator.ofFloat(
                liftCabin,
                "translationY",
                -currentPosition*OFFSET,
                positionOrder*OFFSET
        );
        animator.setDuration(2000);
        animator.start();

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                currentPosition=-currentPosition*OFFSET;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        }

}
