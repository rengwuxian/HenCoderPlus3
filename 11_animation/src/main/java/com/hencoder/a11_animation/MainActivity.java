package com.hencoder.a11_animation;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.graphics.PointF;
import android.os.Bundle;

import com.hencoder.a11_animation.view.ProvinceView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ProvinceView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.view);

        /*view.animate()
                .translationX(Utils.dpToPixel(200))
//                .translationY(Utils.dpToPixel(100))
//                .rotation(90)
                .setStartDelay(1000)
                .start();*/

        /*ObjectAnimator animator = ObjectAnimator.ofFloat(view, "radius", Utils.dpToPixel(150));
        animator.setStartDelay(1000);
        animator.start();*/

        /*ObjectAnimator bottomFlipAnimator = ObjectAnimator.ofFloat(view, "bottomFlip", 30);
        bottomFlipAnimator.setDuration(1000);

        ObjectAnimator topFlipAnimator = ObjectAnimator.ofFloat(view, "topFlip", - 30);
        topFlipAnimator.setStartDelay(200);
        topFlipAnimator.setDuration(1000);

        ObjectAnimator flipRotationAnimator = ObjectAnimator.ofFloat(view, "flipRotation", 270);
        flipRotationAnimator.setStartDelay(200);
        flipRotationAnimator.setDuration(1000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(bottomFlipAnimator, flipRotationAnimator, topFlipAnimator);
        animatorSet.setStartDelay(1000);
        animatorSet.start();*/

        /*PropertyValuesHolder bottomFlipHolder = PropertyValuesHolder.ofFloat("bottomFlip", 30);
        PropertyValuesHolder topFlipHolder = PropertyValuesHolder.ofFloat("topFlip", -30);
        PropertyValuesHolder flipRotationHolder = PropertyValuesHolder.ofFloat("flipRotation", 270);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view, bottomFlipHolder, topFlipHolder, flipRotationHolder);
        animator.setStartDelay(1000);
        animator.setDuration(1000);
        animator.start();*/

        /*float distance = Utils.dpToPixel(300);
        Keyframe keyframe1 = Keyframe.ofFloat(0, 0);
        Keyframe keyframe2 = Keyframe.ofFloat(0.1f, 1.5f * distance);
        Keyframe keyframe3 = Keyframe.ofFloat(0.9f, 0.6f * distance);
        Keyframe keyframe4 = Keyframe.ofFloat(1, distance);
        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("translationX", keyframe1, keyframe2, keyframe3, keyframe4);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view, holder);
        animator.setStartDelay(1000);
        animator.setDuration(2000);
        animator.start();*/

        // start: 0, end: 2, 2 * fraction 2 * 0.25 2 * 0.5
        // start: 1, end: 4, 1 + 3 * fraction. 1 + 3 * 0.25

        /*PointF dest = new PointF(Utils.dpToPixel(200), Utils.dpToPixel(300));
        ObjectAnimator animator = ObjectAnimator.ofObject(view, "point", new PointFEvaluator(), dest);
        animator.setStartDelay(1000);
        animator.setDuration(1000);
        animator.start();*/

        ObjectAnimator animator = ObjectAnimator.ofObject(view, "province", new ProvinceUtil.ProvinceEvaluator(), "澳门特别行政区");
        animator.setStartDelay(1000);
        animator.setDuration(10000);
        animator.start();
    }

    static class PointFEvaluator implements TypeEvaluator<PointF> {
        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
            float x = startValue.x + (endValue.x - startValue.x) * fraction;
            float y = startValue.y + (endValue.y - startValue.y) * fraction;
            return new PointF(x, y);
        }
    }
}
