package player;

import guns.ammoBrick;
import main.Game;
import utils.KeyUtil;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Enemy extends Player {

    private int Health = 1000;
    private int spawnRate = 1;
    private double Speed = 5     * (Math.random() * 1) +1;
    private int Damage = 6;
    private boolean dealingDamage;
    private int x,y,width,height;

    public int geteHealth() {
        return Health;
    }

    public boolean isDealingDamage() {
        return dealingDamage;
    }

    public void setHealth(int health) {
        Health = health;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public Enemy(Game g, KeyUtil keyUtil,int x, int y, int width, int height) {
        super(g, keyUtil);
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public void followPlayer(int playerX, int playerY) {
            if (x < playerX + 25) {
                x += Speed;
            }
            if (y < playerY + 37) {
                y += Speed;
            }
            if (x > playerX + 25) {
                x -= Speed;
            }
            if (y > playerY + 37) {
                y -= Speed;
            }
    }



    public void dealDamage(int playerX,int playerY,Player p) {
        if (x + width >= playerX && x <= playerX + getPlayerWidth() && y + height >= playerY && y <= playerY + getPlayerHeight()) {
            p.setHealth(p.getHealth()-Damage);
            dealingDamage = true;
        }
    }

@Override
    public void draw(Graphics2D g2) {
            g2.setColor(Color.BLUE);
            g2.fillOval(x, y, width, height);

    }
    public void update(int playerX, int playerY) {
        followPlayer(playerX, playerY);
    }
}
