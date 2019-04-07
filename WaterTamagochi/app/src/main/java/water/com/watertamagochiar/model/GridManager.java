package water.com.watertamagochiar.model;

import android.animation.ObjectAnimator;

import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.animation.ModelAnimator;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.AnimationData;
import com.google.ar.sceneform.rendering.ModelRenderable;

import java.util.Random;

public class GridManager {
    private final float gridSize = 2.90f;
    private int gridSizeX = 30;
    private int gridSizeY = 30;

    private final int walkAnimationIndex = 3;


    private Vector3 treeSize = new Vector3(14f, 14f, 14f);
    private Vector3 foxSize = new Vector3(0.1f, 0.1f, 0.1f);
    private float globalScaleMultiplier = 0.1f;

    public TreeObject[][] grid;

    private Random random = new Random();

    private ModelAnimator animator;

    private AnchorNode anchor;

    private ModelRenderable treeModel;
    private ModelRenderable foxModel;

    public GridManager(AnchorNode anchor, ModelRenderable treeModel, ModelRenderable foxModel){
        grid = new TreeObject[gridSizeX][gridSizeY];

        this.anchor = anchor;


        this.treeModel = treeModel;
        this.foxModel = foxModel;

        this.GenerateFoxAnimator();

        FoxObject fox = new FoxObject(foxSize, this.anchor, new Vector3(1.5f, 0f, 0.25f), foxModel, animator, 20);
        FoxObject fox2 = new FoxObject(foxSize, this.anchor, new Vector3(0.5f, 0, 1.75f), foxModel, animator, 180);


    }
    public GridManager(AnchorNode anchor, ModelRenderable treeModel, ModelRenderable foxModel, Tree[] Trees){
        this(anchor, treeModel, foxModel);

        for (int i = 0; i < Trees.length; i++){
            Tree currentTree = Trees[i];
            generateTreeAtGridPosition(currentTree.xPosition, currentTree.yPosition, currentTree.currentIncrements);
        }



    }

    public void generateTreeAtGridPosition(int x, int y){
        this.generateTreeAtGridPosition(x, y, 0);
    }

    public void generateTreeAtGridPosition(int x, int y, int increments){
        if(grid[x][y] == null){
            float randomX = random.nextFloat() * gridSize;
            float randomY = random.nextFloat() * gridSize;

            grid[x][y] = new TreeObject(treeSize, this.anchor, new Vector3(randomX, 0, randomY), increments, treeModel);
        }
    }

    private void GenerateFoxAnimator(){

        if (animator == null || !animator.isRunning()) {
            AnimationData data = foxModel.getAnimationData(walkAnimationIndex);
            animator = new ModelAnimator(data, foxModel);
            animator.setDuration(2000);
            animator.setRepeatCount(ObjectAnimator.INFINITE);
    }
}



}
