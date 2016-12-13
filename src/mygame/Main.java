package mygame;

import com.jme3.animation.AnimControl;
import com.jme3.animation.LoopMode;
import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {

        Node stone = (Node) assetManager.loadModel("Models/StoneMonster.j3o");
        AnimationTools.playAnimation(stone, "walk", LoopMode.Loop);
        
//        // 1st attachment
//        Node at = ((Node)stone.getChild("mixamorig:RightLeg_attachnode"));
//        at.removeFromParent();      
//        AnimationTools.getSkeletonControll(stone).getAttachmentsNode("mixamorig:RightLeg").attachChild(at.getChild(0));
//        
//        // 2nd attachment
//        Node at2 = ((Node)stone.getChild("mixamorig:LeftLeg_attachnode"));
//        at2.removeFromParent();      
//        AnimationTools.getSkeletonControll(stone).getAttachmentsNode("mixamorig:LeftLeg").attachChild(at2.getChild(0));
//        
//        // 3rd attachment
//        Node at3 = ((Node)stone.getChild("mixamorig:RightShoulder_attachnode"));
//        at3.removeFromParent();      
//        AnimationTools.getSkeletonControll(stone).getAttachmentsNode("mixamorig:RightShoulder").attachChild(at3.getChild(0));
        

        rootNode.attachChild(stone);
        //J3OExporter.Save(stone, "/media/idea/My Passport/Java/jME_NB-PW-11-6-2015/TestAttacmentNode/assets/Models/StoneMonster.j3o");

        initLight();
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }

    private void initLight() {
        /**
         * A white, directional light source
         */
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection((new Vector3f(-0.5f, -0.5f, -0.5f)).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun);

    }

}
