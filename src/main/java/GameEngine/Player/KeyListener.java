package GameEngine.Player;

import GameEngine.Block.Block;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent event){
        super.keyPressed(event);
        int key = event.getKeyCode();

        if(key == KeyEvent.VK_D){
            Block.move("right", Block.block);
        } else if (key == KeyEvent.VK_A){
            Block.move("left", Block.block);
        } else if (key == KeyEvent.VK_W){
            Block.move("up", Block.block);
        } else if (key == KeyEvent.VK_S){
            Block.move("down", Block.block);
        }

        if(key == KeyEvent.VK_R){
            Block.block.createNewBlock();
        }
    }
}
