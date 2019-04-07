package water.com.watertamagochiar.model;

import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;

import java.util.Random;

public class GridManager {
    private final float gridSize = 2.5f;
    private int gridSizeX = 30;
    private int gridSizeY = 30;

    private Vector3 treeSize = new Vector3(1f, 1f, 1f);
    private Vector3 foxSize = new Vector3(0.1f, 0.1f, 0.1f);
    private float globalScaleMultiplier = 0.1f;

    public TreeObject[][] grid;

    private Random random = new Random();

    private AnchorNode anchor;

    private ModelRenderable treeModel;
    private ModelRenderable foxModel;

    public GridManager(AnchorNode anchor, ModelRenderable treeModel, ModelRenderable foxModel){
        grid = new TreeObject[gridSizeX][gridSizeY];

        this.anchor = anchor;

        this.treeModel = treeModel;
        this.foxModel = foxModel;

        // FoxObject fox = new FoxObject(foxSize, this.anchor, Vector3.zero(), foxModel);

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


}
