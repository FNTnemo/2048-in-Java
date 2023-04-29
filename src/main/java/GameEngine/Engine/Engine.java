package GameEngine.Engine;

import GameEngine.Block.Block;
import GameEngine.Block.BlockColors;
import GameEngine.Block.BlockPhysic;
import GameEngine.Debug.Debug;
import GameEngine.Render.Render;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Engine  extends JPanel implements ActionListener {

    public static String version = "a0_1";
    public static int dotSize = 64;
    public static int allDots = (WindowEngine.width / Engine.dotSize) * (WindowEngine.height / Engine.dotSize);

    public Engine(){
        setBackground(new Color(BlockColors.Null[0], BlockColors.Null[1], BlockColors.Null[2]));
        init();
    }

    public void init(){
        Timer timer = new Timer(100, this);
        timer.start();
        Block.block.createNewBlock();
        Debug.Log("Game started");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Render.render(g);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //BlockPhysic.checkCollisions();
        BlockPhysic.checkBlockCollision();
    }
}
