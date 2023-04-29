package GameEngine.Engine;

import GameEngine.Player.KeyListener;

import javax.swing.*;

public class WindowEngine extends JFrame {

    public static int xDots = 4;
    public static int yDots = 4;

    public static int width = xDots * Engine.dotSize;
    public static int height = yDots * Engine.dotSize;

    public static  String title = "2048: " + Engine.version;

    public WindowEngine(int width, int height, String title, boolean resizable){
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width + 15, height + 40);
        setLocation(100, 100);
        add(new Engine());
        addKeyListener(new KeyListener());
        setVisible(true);
        setResizable(resizable);
    }

}
