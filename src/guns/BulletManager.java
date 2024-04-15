package guns;

import player.Enemy;
import utils.MouseUtil;

import java.awt.*;
import java.util.ArrayList;

public class BulletManager {
    ArrayList<Bullet> bulletList = new ArrayList<Bullet>();

    Bullet tb;
    MouseUtil mU = new MouseUtil();
    public BulletManager() {
    }

    public void update(int playerX, int playerY, int damage , int playerW, int playerH, Enemy e) {
        for(int i = 0; i < bulletList.size(); i++) {
                tb = bulletList.get(i);
                if(!tb.isDealingDamage()) {
                    tb.dealDamage(playerX, playerY, damage, playerW, playerH, e);
                }
                if(tb.isDealingDamage()) {
                    removeBulelt(tb);
            }                tb.setDealingDamage(false);
        }
    }
    public void updates() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        for(int i = 0; i < bulletList.size(); i++) {
            tb = bulletList.get(i);
            if(tb.getY()  < 0 || tb.getY() > screenHeight || tb.getX() < 0|| tb.getX() > screenWidth + 20) {
                removeBulelt(tb);
            }
            tb.update();
        }
    }

    public void draw(Graphics2D g2) {
            for (Bullet bullet : bulletList) {
                tb = bullet;

                tb.draw(g2);
            }
    }

    public void addBullet(Bullet bullet) {
        bulletList.add(bullet);
    }
    public void removeBulelt(Bullet bullet) {
        bulletList.remove(bullet);
    }
}
