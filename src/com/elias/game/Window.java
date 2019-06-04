package com.elias.game;

import javax.swing.JFrame;

public class Window extends JFrame {

    public Window() {
        setTitle("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(1280, 800));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
