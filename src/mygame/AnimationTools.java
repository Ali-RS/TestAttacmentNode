/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.LoopMode;
import com.jme3.animation.SkeletonControl;
import com.jme3.scene.Node;
import com.jme3.scene.SceneGraphVisitor;
import com.jme3.scene.Spatial;
import java.util.Collection;

/**
 *
 * @author IDEA
 */
public class AnimationTools {

    private static Collection<String> Animations;
    private static SkeletonControl SKELETON_CONTROL;
    private static AnimControl ANIM_CONTROL;

    public static Collection<String> getAnimationNames(Spatial model) {

        SceneGraphVisitor visitor = new SceneGraphVisitor() {

            boolean flag = true;

            @Override
            public void visit(Spatial spatial) {

                if (flag && spatial instanceof Node && spatial.getControl(AnimControl.class) != null) {

                    AnimControl control = spatial.getControl(AnimControl.class);
                    Animations = control.getAnimationNames();
                    flag = false;
                    return;

                }
            }

        };

        model.depthFirstTraversal(visitor);

        return Animations;

    }

    public static void playAnimation(Spatial model, String animationName , LoopMode loopMode) {
        SceneGraphVisitor visitor = new SceneGraphVisitor() {

            @Override
            public void visit(Spatial spatial) {

                if (spatial instanceof Node && spatial.getControl(AnimControl.class) != null) {

                    AnimControl control = spatial.getControl(AnimControl.class);
                    AnimChannel channel;
                    if (control.getNumChannels() > 0) {
                        channel = control.getChannel(0);

                    } else {
                        channel = control.createChannel();
                    }
                    channel.setAnim(animationName);
                    channel.setLoopMode(loopMode);

                }
            }

        };

        model.depthFirstTraversal(visitor);
    }
    
     public static void playAnimation(Spatial model, String animationName , boolean useSpatialName, float speed) {
        SceneGraphVisitor visitor = new SceneGraphVisitor() {

            @Override
            public void visit(Spatial spatial) {

                if (spatial instanceof Node && spatial.getControl(AnimControl.class) != null) {

                    AnimControl control = spatial.getControl(AnimControl.class);
                    AnimChannel channel;
                    if (control.getNumChannels() > 0) {
                        channel = control.getChannel(0);

                    } else {
                        channel = control.createChannel();
                    }
                   
                    String animName=animationName;
                    if(useSpatialName)
                    {
                       animName=spatial.getName().concat(animName);
                    }
                    channel.setAnim(animName);
                    channel.setSpeed(speed);
                    channel.setLoopMode(LoopMode.Loop);

                }
            }

        };

        model.depthFirstTraversal(visitor);
    }

    public static void pauseAnimation(Spatial model) {
        SceneGraphVisitor visitor = new SceneGraphVisitor() {

            @Override
            public void visit(Spatial spatial) {

                if (spatial instanceof Node && spatial.getControl(AnimControl.class) != null) {

                    AnimControl control = spatial.getControl(AnimControl.class);
                    AnimChannel channel;
                    if (control.getNumChannels() > 0) {
                        channel = control.getChannel(0);
                        channel.setLoopMode(LoopMode.DontLoop);

                    }

                }
            }

        };

        model.depthFirstTraversal(visitor);
    }

   

    public static SkeletonControl getSkeletonControll(Spatial SPATIAL) {
        SKELETON_CONTROL = null;

        SceneGraphVisitor visitor = new SceneGraphVisitor() {

            @Override
            public void visit(Spatial spatial) {

                if (spatial instanceof Node && spatial.getControl(SkeletonControl.class) != null && SKELETON_CONTROL == null) {

                    SKELETON_CONTROL = spatial.getControl(SkeletonControl.class);

                    return;
                }
            }

        };

        SPATIAL.depthFirstTraversal(visitor);
        return SKELETON_CONTROL;
    }
    
    public static AnimControl getAnimControl(Spatial Spatial)
    {
        ANIM_CONTROL=null;
        SceneGraphVisitor visitor =new SceneGraphVisitor() {
           
            @Override
            public void visit(Spatial spatial) {
                 if (spatial instanceof Node && spatial.getControl(AnimControl.class) != null) {

                      ANIM_CONTROL=spatial.getControl(AnimControl.class);
                      return;
                     
                 }
                 
            }
        };
        
        Spatial.depthFirstTraversal(visitor);
        return ANIM_CONTROL;
    }

}
