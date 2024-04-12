package guns;

import utils.MouseUtil;

import java.awt.*;
import java.util.ArrayList;

public class BulletManager {
    private ArrayList<Bullet> bulletList = new ArrayList<Bullet>();

    Bullet tb;
    MouseUtil mU = new MouseUtil();

    public void update(int px, int py) {
            for (Bullet bullet : bulletList) {
                tb = bullet;

                tb.update(px, py);
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