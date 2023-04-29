package GameEngine;

import GameEngine.Engine.WindowEngine;

public class Main {
    public static void main(String[] args){
        new WindowEngine(WindowEngine.width, WindowEngine.height, WindowEngine.title, true);
    }
}
