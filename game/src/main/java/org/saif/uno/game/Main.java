package org.saif.uno.game;

import org.saif.uno.engine.Game;

public class Main {
    public static void main(String[] args) {

        try {
            Game game = new ConsoleGame();
            game.run();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}