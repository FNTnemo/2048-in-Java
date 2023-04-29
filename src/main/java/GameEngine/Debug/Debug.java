package GameEngine.Debug;

import GameEngine.Block.BlockColors;
import GameEngine.Engine.Engine;
import GameEngine.Engine.WindowEngine;

import java.awt.*;

public class Debug {
    public static void Log(String text){
        System.out.println(text);
    }
    public static void net(Graphics g){
        g.setColor(Color.black);
        for (int i = 0; (WindowEngine.height / Engine.dotSize)*2 > i; i++) {
            g.drawLine(0, i*Engine.dotSize, WindowEngine.height, i*Engine.dotSize);
        }
        for (int i = 0; (WindowEngine.width / Engine.dotSize)*2 > i ; i++) {
            g.drawLine(i*Engine.dotSize, 0, i*Engine.dotSize, WindowEngine.height);
        }
    }
}
