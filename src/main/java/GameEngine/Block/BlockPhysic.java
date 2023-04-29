package GameEngine.Block;

import GameEngine.Debug.Debug;
import GameEngine.Engine.Engine;
import GameEngine.Engine.WindowEngine;

public class BlockPhysic {

    public static void checkCollisions() {
        for (Block block : Block.blocks) {
            if (block.x < 0) {
                block.x = 0;
            } else if ( block.x > WindowEngine.width - (Engine.dotSize)) {
                block.x = WindowEngine.width - Engine.dotSize;
            }else if (block.y < 0) {
                block.y = 0;
            } else if (block.y > WindowEngine.height - (Engine.dotSize)) {
                block.y = WindowEngine.height - Engine.dotSize;
            }
        }
    }

    public static void checkBlockCollision(){
        for (int id = 0; id < Block.blocks.size(); id++) {

            for(Block block : Block.blocks){

                if(block != Block.blocks.get(id)){
                    if(block.x == Block.blocks.get(id).x && block.y == Block.blocks.get(id).y){
                        if(block.blockNum == Block.blocks.get(id).blockNum){

                            Block.blocks.remove(id);
                            block.numUp();
                            return;

                        }
                        Debug.Log("разные значения");
                    }
                }

            }

        }
    }

    public static boolean canMoveR(Block block){
        if(block.x + Engine.dotSize > WindowEngine.width - (Engine.dotSize))
            return false;
        for (int id = 0; id < Block.blocks.size(); id++) {
            if (block.blockNum != Block.blocks.get(id).blockNum){
                if(block.x + Engine.dotSize == Block.blocks.get(id).x && block.y == Block.blocks.get(id).y){
                    return false;
                }
            }
        }
        return true;

    }
    public static boolean canMoveL(Block block){
        if(block.x - Engine.dotSize < 0)
            return false;
        for (int id = 0; id < Block.blocks.size(); id++) {
            if (block.blockNum != Block.blocks.get(id).blockNum){
                if(block.x - Engine.dotSize == Block.blocks.get(id).x && block.y == Block.blocks.get(id).y){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean canMoveU(Block block){
        if(block.y - Engine.dotSize < 0)
            return false;
        for (int id = 0; id < Block.blocks.size(); id++) {
            if (block.blockNum != Block.blocks.get(id).blockNum){
                if(block.y - Engine.dotSize == Block.blocks.get(id).y && block.x == Block.blocks.get(id).x){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean canMoveD(Block block){
        if(block.y + Engine.dotSize > WindowEngine.height - (Engine.dotSize))
            return false;
        for (int id = 0; id < Block.blocks.size(); id++) {
            if (block.blockNum != Block.blocks.get(id).blockNum){
                if(block.y + Engine.dotSize == Block.blocks.get(id).y && block.x == Block.blocks.get(id).x){
                    return false;
                }
            }
        }
        return true;
    }
}
