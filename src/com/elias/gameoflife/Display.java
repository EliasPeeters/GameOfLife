package com.elias.gameoflife;

import javax.swing.JFrame;
import java.awt.*;

public class Display {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, heigth;

    public Display(String title, int width, int heigth) {
        this.title = title;
        this.width = width;
        this.heigth = heigth;

        createDisplay();
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, heigth);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, heigth));
        canvas.setMaximumSize(new Dimension(width, heigth));
        canvas.setMinimumSize(new Dimension(width, heigth));

        frame.add(canvas);
        frame.pack();
    }

}
