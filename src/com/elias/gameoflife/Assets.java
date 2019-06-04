package com.elias.gameoflife;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 233, height = 283;

    public static BufferedImage[] player = new BufferedImage[3];

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLodaer.loadImage("/textures/players.png"));

        player[0] = sheet.crop(0,0, width, height);
        player[1] = sheet.crop(width,0, width, height);
        player[2] = sheet.crop(2*width,0, width, height);
    }
}
