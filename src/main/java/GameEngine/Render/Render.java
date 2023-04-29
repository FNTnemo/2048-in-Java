package GameEngine.Render;

import GameEngine.Block.Block;
import GameEngine.Debug.Debug;

import java.awt.*;

public class Render {
    public static void render(Graphics g){
        Block.renderBlock(g);
        Debug.net(g);
    }
}
