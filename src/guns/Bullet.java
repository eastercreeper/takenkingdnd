package guns;

import java.awt.*;

public class Bullet {
    private int ammoType;
    private int x,y;
    public Bullet(int ammoType) {
        this.ammoType = ammoType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Graphics2D g2) {
        if(ammoType == 1) {
            g2.setColor(Color.white);
            g2.fillRect(x,y,10,3);
        }
        if(ammoType == 2) {
            g2.setColor(Color.GREEN);
            g2.fillRect(x,y,10,5);
        }
        if(ammoType == 3) {
            g2.setColor(new Color(131, 0, 255));
            g2.fillOval(x,y,15,8);
        }
    }
    public void update(int playerX, int playerY) {

    }
}
