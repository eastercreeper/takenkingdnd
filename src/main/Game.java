package main;

import classes.Warlock;
import guns.Bullet;
import guns.BulletManager;
import org.lwjgl.Sys;
import player.Enemy;
import player.EnemyManager;
import player.Player;
import utils.KeyUtil;
import utils.MouseUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JPanel implements Runnable {
    Thread gameThread;
    KeyUtil keyUtil = new KeyUtil();
    MouseUtil mouseUtil = new MouseUtil();
    Warlock warlock = new Warlock(this,keyUtil);
    Enemy enemy;
    private int y = warlock.getY();
    private int x = warlock.getX();
    private int wave = 11;



    public int getMultiplierFPS() {
        return multiplierFPS;
    }

    int FPS = 60;
    int baseFPS = 60;
    int multiplierFPS = 1;
    private EnemyManager eM = new EnemyManager(wave);
    private BulletManager bM;

    Bullet bullet;



    public Game() {
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyUtil);
        this.addMouseListener(mouseUtil);
        this.setFocusable(true);
    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
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
                //System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update() {
        warlock.update();
        //.out.println(warlock.getHealth());
        if(warlock.getHealth() <= 0) {
            //gameThread.stop();
        }
        eM.update(warlock.getX(),warlock.getY(), warlock);
        if(mouseUtil.isLmb()) {
            bM = new BulletManager(x,y, mouseUtil.getX(), mouseUtil.getY());
            bM.update();
        }

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        warlock.draw(g2);
        eM.draw(g2);
        if(mouseUtil.isLmb()) {
            bM.draw(g2);
        }
        g2.dispose();
    }
}
