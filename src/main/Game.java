package main;

import classes.Warlock;
import org.lwjgl.Sys;
import player.Player;
import utils.KeyUtil;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements Runnable {
    Thread gameThread;
    KeyUtil keyUtil = new KeyUtil();
    Warlock warlock = new Warlock(this,keyUtil);
    private int y = warlock.getY();
    private int x = warlock.getX();

    public int getMultiplierFPS() {
        return multiplierFPS;
    }

    int FPS = 240;
    int baseFPS = 60;
    int multiplierFPS = FPS/baseFPS;



    public Game() {
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyUtil);
        this.setFocusable(true);
    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
//    public void run() {
//
//        double drawInterval = 1000000000/FPS;
//        double nextDrawTime = System.nanoTime() + drawInterval;
//        while(gameThread != null) {
//            //draw character\
//            update();
//            //movement
//            repaint();
//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/1000000;
//                if(remainingTime < 0) {
//                    remainingTime = 0;
//                }
//
//                Thread.sleep((long) remainingTime);
//
//                nextDrawTime += drawInterval;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public void run() {
        double drawInterval = 1000000000.0 /FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update() {
        warlock.update();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        warlock.draw(g2);


        //g2.dispose();
    }
}
