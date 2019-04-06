package water.com.watertamagochiar.model;

import android.animation.ObjectAnimator;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.view.animation.LinearInterpolator;

import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.animation.ModelAnimator;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.QuaternionEvaluator;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.AnimationData;
import com.google.ar.sceneform.rendering.ModelRenderable;

import java.util.Vector;

public class FoxObject extends Node {

    @Nullable
    private ObjectAnimator orbitAnimation = null;
    private float degreesPerSecond = 90.0f;

    private final boolean isOrbit = true;
    private final boolean clockwise = true;
    private final float axisTiltDeg = 90;
    private float lastSpeedMultiplier = 1.0f;

    private ModelRenderable foxRenderable;
    private final int walkAnimationIndex = 3;


    private Vector3 originalSize;
    private AnchorNode thisAnchorNode;
    private ModelAnimator animator;

    public FoxObject(Vector3 originalSize, AnchorNode anchorPosition, Vector3 adittionalPosition, ModelRenderable foxModel){
        this.originalSize = originalSize;


        AnchorNode fox = new AnchorNode();
        fox.setLocalScale(this.originalSize.scaled(Game_Constants.globalScaleMultiplier));
        fox.setParent(anchorPosition);
        fox.setLocalPosition(adittionalPosition.scaled(Game_Constants.globalScaleMultiplier));
        this.thisAnchorNode = fox;
        fox.setRenderable(foxModel);
        foxRenderable = foxModel;
        onPlayAnimation();
    }

    @Override
    public void onUpdate(FrameTime frameTime) {
        super.onUpdate(frameTime);


        System.out.println("RAN ONUPDATE");

    }

    private void onPlayAnimation() {
        if (animator == null || !animator.isRunning()) {
            AnimationData data = foxRenderable.getAnimationData(walkAnimationIndex);
            animator = new ModelAnimator(data, foxRenderable);
            animator.setDuration(600);
            animator.setRepeatCount(ObjectAnimator.INFINITE);
            animator.start();
        }
    }

}
