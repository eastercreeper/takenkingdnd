package player;

import guns.ammoBrick;
import main.Game;
import org.lwjgl.Sys;
import utils.KeyUtil;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Enemy {

    private int Health = 1000;
    private double Speed = 1;
    private int Damage = 8;
    private boolean dealingDamage;
    final protected int xOrigin, yOrigin;
    private int width,height;
    protected double angle;
    protected double x, y;
    protected double nx, ny;

    public int geteHealth() {
        return Health;
    }

    public boolean isDealingDamage() {
        return dealingDamage;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }

    public Enemy(int x, int y, int width, int height, int Speed) {
        xOrigin = x;
        yOrigin = y;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.Speed = Speed;
    }




    public void dealDamage(int playerX,int playerY,Player p, int playerWidth, int playerHeight) {
        if (x + width >= playerX && x <= playerX + playerWidth && y + height >= playerY && y <= playerY + playerHeight) {
            p.setHealth(p.getHealth()-Damage);
            dealingDamage = true;
        }
    }

    public void draw(Graphics2D g2) {
            g2.setColor(Color.BLUE);
            g2.fillOval((int)x, (int)y, width, height);
            g2.setColor(Color.white);

        g2.drawRect((int)x-1,(int)y-height+14,26,9);

        g2.fillRect((int)x,(int)y-height+15,(Health/40),height/3);
    }
    public void update(int playerX, int playerY) {
        double dx = playerX - x;
        double dy = playerY - y;
        double dir = Math.atan2(dy, dx);
        angle = dir +Math.toRadians(Math.random() * 10);
        nx = Speed * Math.cos(angle);
        ny = Speed * Math.sin(angle);
        x += nx;
        y += ny;
    }
}
