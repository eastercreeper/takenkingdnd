package main;

import classes.Warlock;
import org.lwjgl.Sys;
import player.Enemy;
import player.Player;
import utils.KeyUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JPanel implements Runnable {
    Thread gameThread;
    KeyUtil keyUtil = new KeyUtil();
    Warlock warlock = new Warlock(this,keyUtil);
    Enemy enemy;
    private int y = warlock.getY();
    private int x = warlock.getX();
    private int wave = 11;

    ArrayList<Enemy> enemies;

    public int getMultiplierFPS() {
        return multiplierFPS;
    }

    int FPS = 60;
    int baseFPS = 60;
    int multiplierFPS = 1;



    public Game() {
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyUtil);
        this.setFocusable(true);
        enemies = new ArrayList<Enemy>();
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
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update() {
        warlock.update();
        if(enemies.isEmpty()) {
            for (int i = 0; i < 11; i++) {
                enemies.add(new Enemy(this, keyUtil, 25, 25));
                enemies.get(i).setSpeed((int) (Math.random() * 4) + 1);
                enemies.get(i).setX((int) (Math.random() * 1920 ));
                enemies.get(i).setY((int) (Math.random() * 1080 ));
            }
        }
        for(int j = 0; j < 11; j++) {
            if(enemies.get(j).geteHealth() <= 0) {
                enemies.remove(j);
            }
        }
        for (Enemy enemy : enemies) {
            enemy.update(warlock.getX(), warlock.getY(), warlock);
        }

        System.out.println(warlock.getHealth());
        if(warlock.getHealth() <= 0) {
            //gameThread.stop();
        }
        if(enemies.isEmpty()) {
            wave++;
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        warlock.draw(g2);
        for (Enemy enemy : enemies) {
            enemy.draw(g2);
        }


        g2.dispose();
    }
}
