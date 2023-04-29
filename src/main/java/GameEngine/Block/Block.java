package GameEngine.Block;

import GameEngine.Debug.Debug;
import GameEngine.Engine.Engine;
import GameEngine.Engine.WindowEngine;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Block {

    public static ArrayList<Block> blocks = new ArrayList<>();
    public static Block block = new Block(0, 0, 0);

    int x;
    int y;

    int blockNum;

    static Random random = new Random();

    public Block(int x, int y, int blockNum){
        this.blockNum = blockNum;
        this.x = x;
        this.y = y;
    }

    public static int randomCordX(){
        int x = random.nextInt(0, 4);
        x*=Engine.dotSize;
        return x;
    }
    public static int randomCordY(){
        int y = random.nextInt(0, 4);
        y*=Engine.dotSize;
        return y;
    }

    public void createNewBlock(){

        int x = randomCordX();
        int y = randomCordY();

        if(blocks.size() < WindowEngine.xDots*WindowEngine.yDots){

            for (Block block:blocks) {
                if(x == block.x && y == block.y) {
                    createNewBlock();
                    return;
                }
            }

            blockNum = 2;

            blocks.add(new Block(x, y, blockNum));
            Debug.Log("Created a new block");
        } else {
            Debug.Log("lose");
        }
    }
    public static void renderBlock(Graphics g){
        for (Block block: blocks) {
            checkColor(g, block);
            g.fillRect(block.x, block.y, Engine.dotSize, Engine.dotSize);
            renderBlockNum(g, block);
        }
    }

    public static void renderBlockNum( Graphics g, Block block){
        g.setColor(new Color(BlockColors.text[0], BlockColors.text[1], BlockColors.text[2]));
        g.drawString(Integer.toString(block.blockNum), block.x + Engine.dotSize/2, block.y + Engine.dotSize/2);
    }

    public void numUp(){
        blockNum *= 2;
    }

    public static void move(String vector, Block Block){
        for (Block block : blocks){
            if (vector == "right" && BlockPhysic.canMoveR(block)){
                while (BlockPhysic.canMoveR(block)){
                    block.x += Engine.dotSize;
                }
            } else if (vector == "left" && BlockPhysic.canMoveL(block)) {
                while (BlockPhysic.canMoveL(block)){
                    block.x -= Engine.dotSize;
                }
            } else if (vector == "up" && BlockPhysic.canMoveU(block)) {
                while (BlockPhysic.canMoveU(block)){
                    block.y -= Engine.dotSize;
                }
            } else if (vector == "down" && BlockPhysic.canMoveD(block)) {
                while (BlockPhysic.canMoveD(block)){
                    block.y += Engine.dotSize;
                }
            }
        }
    }



    public static void checkColor(Graphics g, Block block){
        switch (block.blockNum) {
            case 2 -> g.setColor(new Color(BlockColors.a2[0], BlockColors.a2[1], BlockColors.a2[2]));
            case 4 -> g.setColor(new Color(BlockColors.a4[0], BlockColors.a4[1], BlockColors.a4[2]));
            case 8 -> g.setColor(new Color(BlockColors.a8[0], BlockColors.a8[1], BlockColors.a8[2]));
            case 16 -> g.setColor(new Color(BlockColors.a16[0], BlockColors.a16[1], BlockColors.a16[2]));
            case 32 -> g.setColor(new Color(BlockColors.a32[0], BlockColors.a32[1], BlockColors.a32[2]));
            case 64 -> g.setColor(new Color(BlockColors.a64[0], BlockColors.a64[1], BlockColors.a64[2]));
            case 128 -> g.setColor(new Color(BlockColors.a128[0], BlockColors.a128[1], BlockColors.a128[2]));
            case 256 -> g.setColor(new Color(BlockColors.a256[0], BlockColors.a256[1], BlockColors.a256[2]));
            case 512 -> g.setColor(new Color(BlockColors.a512[0], BlockColors.a512[1], BlockColors.a512[2]));
            case 1024 -> g.setColor(new Color(BlockColors.a1024[0], BlockColors.a1024[1], BlockColors.a1024[2]));
            case 2048 -> g.setColor(new Color(BlockColors.a2048[0], BlockColors.a2048[1], BlockColors.a2048[2]));
            default -> Debug.Log("block not found");
        }
    }


}
