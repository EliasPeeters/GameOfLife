package com.elias.gameoflife;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLodaer {

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(ImageLodaer.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;

    }
}
