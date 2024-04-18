package guns;

import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import player.Enemy;
import utils.MouseUtil;

import java.awt.*;

public class Bullet {
    final protected int xOrigin, yOrigin;
    protected double angle;
    protected double x, y;
    protected double nx, ny;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    protected double distance;
    protected double speed, range, damage;
    private boolean dealingDamage = false;
    protected int mouseX, mouseY;

    public boolean isDealingDamage() {
        return dealingDamage;
    }

    public void setDealingDamage(boolean dealingDamage) {
        this.dealingDamage = dealingDamage;
    }

    BulletManager bulletManager = new BulletManager();

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Bullet(int x, int y, int mouseX, int mouseY) {
        xOrigin = x;
        yOrigin = y;
        this.x = x;
        this.y = y;
        range = 200;
        damage = .1d;
        speed = 10;
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        double dx = mouseX - x;
        double dy = mouseY - y;
        double dir = Math.atan2(dy, dx);
        angle = dir +Math.toRadians(Math.random() * 5);
        System.out.println(Math.toDegrees(angle));
//        if(Math.toDegrees(angle) < -60) {
//            angle = Math.toRadians(-60);
//        } else if(Math.toDegrees(angle) > 60) {
//            angle = Math.toRadians(60);
//        }
        nx = speed * Math.cos(angle);
        ny = speed * Math.sin(angle);
    }


    public void update() {
            move();
    }

    public void dealDamage(int playerX, int playerY, int damage , int playerW, int playerH, Enemy e) {
        if (x + 5 >= playerX && x <= playerX + playerW && y + 5 >= playerY && y <= playerY + playerH) {
            e.setHealth(e.geteHealth() - damage);
            dealingDamage = true;
        }
    }

    public void move() {
        x += nx;
        y += ny;
    }


    public void draw(Graphics2D g2) {
            g2.setColor(Color.YELLOW);
            g2.fillOval((int)x,(int)y,5,5);
    }
}
