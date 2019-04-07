package water.com.watertamagochiar.model;

import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;

public class TreeObject {
    private Vector3 originalSize;
    public final float sizeToScaleToMultiplier = 0.05f;
    private final int increments = 10;
    private float incrementScaleAmount;
    public int currentIncrement = 0;
    private Vector3 targetSize;
    private AnchorNode thisAnchorNode;

    private float scaleDeadzone = 0.0001f;

    private boolean treeIsGrowing = false;

    public TreeObject(Vector3 originalSize, AnchorNode anchorPosition, Vector3 adittionalPosition, int increments, ModelRenderable treeModel){
        this.originalSize = originalSize;
        this.incrementScaleAmount = sizeToScaleToMultiplier / this.increments;


        AnchorNode tree = new AnchorNode();
        tree.setLocalScale(this.originalSize.scaled(Game_Constants.globalScaleMultiplier));
        tree.setParent(anchorPosition);
        tree.setLocalPosition(adittionalPosition.scaled(Game_Constants.globalScaleMultiplier));
        this.thisAnchorNode = tree;
        growTree(increments);
        tree.setRenderable(treeModel);

    }



    public void growTree(int incrementsToGrow){
        this.currentIncrement += incrementsToGrow;
        if (this.currentIncrement > increments){
            this.currentIncrement = increments;
        }
        else{
            this.targetSize = this.originalSize.scaled(this.currentIncrement * incrementScaleAmount);
            grow();
        }
    }

    // Only tests difference between two
    public void grow(){
        /*while (Math.abs(targetSize.x - originalSize.scaled(increments * incrementScaleAmount).x) > scaleDeadzone){
            // 0.2f should be time.deltatime but i come from C# so i dont know how to do that just hopes it works
             this.thisAnchorNode.setLocalScale(Vector3.lerp(originalSize, targetSize, 0.2f));
        }
*/
    this.thisAnchorNode.setLocalScale(targetSize);

    }





}
