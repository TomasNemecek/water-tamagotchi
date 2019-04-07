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


    private Vector3 originalSize;
    private AnchorNode thisAnchorNode;
    private ModelAnimator animator;

    public FoxObject(Vector3 originalSize, AnchorNode anchorPosition, Vector3 adittionalPosition, ModelRenderable foxModel, ModelAnimator animator, float rotationY){
        this.originalSize = originalSize;


        AnchorNode fox = new AnchorNode();
        fox.setLocalScale(this.originalSize.scaled(Game_Constants.globalScaleMultiplier));
        fox.setParent(anchorPosition);
        fox.setLocalPosition(adittionalPosition.scaled(Game_Constants.globalScaleMultiplier));
        fox.setLocalRotation(new Quaternion(new Vector3(0, rotationY, 0)));
        this.thisAnchorNode = fox;
        fox.setRenderable(foxModel);
        foxRenderable = foxModel;
        this.animator = animator;



        onPlayAnimation();
    }



    private void onPlayAnimation() {

        if(!animator.isStarted()){
            animator.start();

        }
    }

}
