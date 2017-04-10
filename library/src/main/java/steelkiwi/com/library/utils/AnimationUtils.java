package steelkiwi.com.library.utils;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

/**
 * Created by yaroslav on 4/5/17.
 */

public class AnimationUtils {

    public static ObjectAnimator translateByY(View view, float positionY, int duration, Interpolator interpolator){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", positionY);
        animator.setDuration(duration);
        animator.setInterpolator(interpolator);
        animator.start();
        return animator;
    }

    public static ObjectAnimator translateByY(Drawable drawable, float positionY, int duration, Interpolator interpolator){
        ObjectAnimator animator = ObjectAnimator.ofFloat(drawable, "translationY", positionY);
        animator.setDuration(duration);
        animator.setInterpolator(interpolator);
        animator.start();
        return animator;
    }

    public static ObjectAnimator translateByX(View view, float positionX, int duration){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", positionX);
        animator.setDuration(duration);
        animator.setInterpolator(new OvershootInterpolator());
        animator.start();
        return animator;
    }

    public static ObjectAnimator rotate(View view, float startDegree, float endDegree, int duration){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", startDegree, endDegree);
        animator.setDuration(duration);
        animator.setRepeatCount(-1);
        animator.start();
        return animator;
    }

    public static ObjectAnimator rotateByY(View view, float startDegree, float endDegree, int duration){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotationY", startDegree, endDegree);
        animator.setDuration(duration);
        animator.setRepeatCount(-1);
        animator.start();
        return animator;
    }

    public static ObjectAnimator alpha(View view, float alpha, int duration, Interpolator interpolator){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", alpha);
        animator.setDuration(duration);
        animator.setInterpolator(interpolator);
        animator.start();
        return animator;
    }

    public static ObjectAnimator alpha(Drawable drawable, float alpha, int duration, Interpolator interpolator){
        ObjectAnimator animator = ObjectAnimator.ofFloat(drawable, "alpha", alpha);
        animator.setDuration(duration);
        animator.setInterpolator(interpolator);
        animator.start();
        return animator;
    }
}
