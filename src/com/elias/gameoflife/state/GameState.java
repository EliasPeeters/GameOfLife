package com.elias.gameoflife.state;

import com.elias.gameoflife.Assets;

import java.awt.*;

public class GameState extends State{

    public GameState() {

    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(Assets.player[1], 0, 0, null);
    }
}
