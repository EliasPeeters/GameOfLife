package com.elias.gameoflife;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("GameOfLife", 1000, 600);
        game.start();
    }

}
