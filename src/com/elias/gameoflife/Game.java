package com.elias.gameoflife;

import com.elias.gameoflife.state.GameState;
import com.elias.gameoflife.state.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Display display;
    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;


    public int width, height;
    public String title;
    public int fps = 60;

    private State gamestate;


    public Game(String title, int width, int heigth) {
        this.width = width;
        this.height = heigth;
        this.title = title;

    }

    public void run() {
        init();


        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;


        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now-lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                delta--;
                ticks++;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
    stop();
}

    public void init() {
        display = new Display(title, width, height);
        Assets.init();

        gamestate = new GameState();
        State.setState(gamestate);

    }


    public void tick() {
        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0,0, width, height);

        //Draw Begin
        g.setColor(new Color(35, 105, 230));
        //g.drawRect(100, 100, 100, 100);
        g.drawImage(Assets.player[0], 0,0, null);
        //g.drawString(Integer.toString(fps), 0, 0);
        //g.drawString("test", 100, 100);
        //Draw End

        if (State.getState() != null) {
            State.getState().render(g);
        }


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
