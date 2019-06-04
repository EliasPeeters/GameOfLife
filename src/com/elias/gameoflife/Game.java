package com.elias.gameoflife;

public class Game {

    private Display display;

    public int width, height;

    public Game(String title, int width, int heigth) {
        this.width = width;
        this.height = heigth;

        display = new Display(title, width, heigth);
    }

}
