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

public class    Game extends JPanel implements Runnable {
    Thread gameThread;
    KeyUtil keyUtil = new KeyUtil();
    MouseUtil mouseUtil = new MouseUtil();
    Warlock warlock = new Warlock(this,keyUtil);
    Enemy enemy;
    private int y = warlock.getY();
    private int x = warlock.getX();
    private int wave = 1;



    public int getMultiplierFPS() {
        return multiplierFPS;
    }

    int FPS = 60;
    int baseFPS = 60;
    int multiplierFPS = 1;
    private int kills = 0;
    private int realwave = 1;
    private int prevKills;
    private EnemyManager eM = new EnemyManager(wave, warlock.getX(), warlock.getY());
    private BulletManager bM = new BulletManager();
    public Game() {
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyUtil);
        this.addMouseListener(mouseUtil);
        this.addMouseMotionListener(mouseUtil);
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

        if(MouseUtil.getButton() ==1) {

            bM.addBullet(new Bullet(warlock.getX()+warlock.getPlayerWidth(),warlock.getY()+(warlock.getPlayerHeight()/2),MouseUtil.getX(),MouseUtil.getY() ));
        }
        if(!eM.getE().isEmpty()) {
            for (int i = 0; i < eM.getE().size(); i++) {
                int enemyX = eM.getE().get(i).getX();
                int enemyY = eM.getE().get(i).getY();
                bM.update(enemyX, enemyY, 100, 25, 25, eM.getE().get(i));
            }
        }
        bM.updates();

        if(eM.getE().isEmpty()) {
            wave+=10;
            realwave++;
            prevKills += eM.getKills();
            eM = new EnemyManager(wave, warlock.getX(), warlock.getY());
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        warlock.draw(g2);
        eM.draw(g2);
        bM.draw(g2);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        g2.setColor(Color.WHITE);

        g2.drawRect(screenWidth/2-251, 99,501,26);

        g2.setColor(Color.WHITE);
        if(warlock.getHealth() <= 200 && warlock.getHealth() > 80) {
            g2.fillRect(screenWidth / 2 - 250, 100, (int) (warlock.getHealth() * 2.5), 25);
        }
        if(warlock.getHealth() <= 80 && warlock.getHealth() > 0) {

            g2.setColor(new Color(176, 0, 0));
            g2.fillRect(screenWidth / 2 - 250, 100, (int) (warlock.getHealth() * 2.5), 25);
        }
        if(warlock.getHealth() <=0) {
            g2.fillRect(screenWidth / 2 - 250, 100, 0, 25);
        }
            if(warlock.getHealth() > 200) {
            g2.fillRect(screenWidth / 2 - 250, 100, 500, 25);

            g2.setColor(new Color(0, 234, 255));
            g2.fillRect(screenWidth / 2 - 250, 100, (int) ((int) (warlock.getHealth()-200)*33.4), 25);
        }
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("LEMONMILK-Regular", Font.BOLD,20));
        g2.drawString("Wave: " + realwave, 0,20);
        g2.drawString("Kills: " + (eM.getKills() + prevKills), 0,40);
        if(warlock.getHealth() <=0 ) {
            g2.setColor(new Color(255, 186, 0));
            g2.setFont(new Font("LEMONMILK-Regular", Font.BOLD,100));
            g2.drawString("You died", 680,480);
            gameThread.stop();
        }
        g2.dispose();
    }
}
