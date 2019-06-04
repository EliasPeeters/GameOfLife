package com.elias.gameoflife;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Display display;
    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    public int width, height;
    public String title;


    public Game(String title, int width, int heigth) {
        this.width = width;
        this.height = heigth;
        this.title = title;

    }

    public void run() {
        init();

        while (running) {
            tick();
            render();
        }
        stop();
    }

    public void init() {
        display = new Display(title, width, height);
    }

    public void tick() {

    }

    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.fillRect(0,0, width, height);

        bs.show();
        g.dispose();
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
